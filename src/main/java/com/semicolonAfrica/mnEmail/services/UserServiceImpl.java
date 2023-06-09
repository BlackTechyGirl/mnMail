package com.semicolonAfrica.mnEmail.services;

import com.semicolonAfrica.mnEmail.data.dto.requests.AddContactRequest;
import com.semicolonAfrica.mnEmail.data.dto.requests.LoginRequest;
import com.semicolonAfrica.mnEmail.data.dto.requests.MessageRequest;
import com.semicolonAfrica.mnEmail.data.dto.requests.RegistrationRequest;
import com.semicolonAfrica.mnEmail.data.dto.response.AddContactResponse;
import com.semicolonAfrica.mnEmail.data.dto.response.LoginResponse;
import com.semicolonAfrica.mnEmail.data.dto.response.MessageResponse;
import com.semicolonAfrica.mnEmail.data.dto.response.RegistrationResponse;
import com.semicolonAfrica.mnEmail.data.model.Contact;
import com.semicolonAfrica.mnEmail.data.model.User;
import com.semicolonAfrica.mnEmail.data.repository.UserRepo;
import com.semicolonAfrica.mnEmail.utils.UserLoginException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Autowired
    private MessageService messageService;
    @Autowired
    private ContactService contactService;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        boolean emailExist = userRepo.findByEmailAddress(request.getEmailAddress()).isPresent();
        if (emailExist) throw new IllegalStateException("Email Already Exist");
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmailAddress(request.getEmailAddress());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setGender(request.getGender());
        userRepo.save(user);

        return RegistrationResponse.builder()
                .message("Account created successfully")
                .status(HttpStatus.CREATED)
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepo.findByEmailAddress(request.getEmailAddress())
                .orElseThrow(()-> new UserLoginException("User does not exist"));
        LoginResponse response = new LoginResponse();
        if (user.getPassword().equals(request.getPassword())){
            response.setMessage("Login successful");
            response.setHttpStatus(HttpStatus.OK);
        }else {
            response.setMessage("re-login");
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            throw new UserLoginException("wrong email or password");
        }
        return response;
    }
    @Override
    public AddContactResponse addContact(AddContactRequest contactRequest) {
        User user = userRepo.findById(contactRequest.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));

        boolean foundContact = contactService.findByEmailAddress(contactRequest.getContact().getEmailAddress()).isPresent();
        Contact contact = new Contact();
        if (foundContact){
            throw new RuntimeException("Contact already exist");
        }else {
            contact.setFullName(contactRequest.getContact().getFullName());
            contact.setEmailAddress(contactRequest.getContact().getEmailAddress());
            contactService.addContact(contact);
            user.getContacts().add(contact);
            userRepo.save(user);
        }

        return AddContactResponse.builder()
                .message("contact added successfully")
                .httpStatus(HttpStatus.OK)
                .build();
    }
    @Override
    public List<Contact> viewContact(User user) {
        return user.getContacts();
    }

    @Override
    public MessageResponse send(MessageRequest request) throws MessagingException {
        messageService.send(request);
        return MessageResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Message sent successfully")
                .build();
    }

}

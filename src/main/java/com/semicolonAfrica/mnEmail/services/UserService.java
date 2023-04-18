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
import jakarta.mail.MessagingException;

import java.util.List;

public interface UserService {
    RegistrationResponse register(RegistrationRequest request);
    LoginResponse login(LoginRequest request);
    AddContactResponse addContact(AddContactRequest contactRequest);
    List<Contact> viewContact(User user);

    MessageResponse send(MessageRequest request) throws MessagingException;
}

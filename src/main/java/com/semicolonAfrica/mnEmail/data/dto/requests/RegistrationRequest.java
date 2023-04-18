package com.semicolonAfrica.mnEmail.data.dto.requests;

import com.semicolonAfrica.mnEmail.data.model.Gender;
import lombok.Data;

@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    private Gender gender;
}

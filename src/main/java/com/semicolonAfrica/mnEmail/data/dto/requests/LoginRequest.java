package com.semicolonAfrica.mnEmail.data.dto.requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String emailAddress;
    private String password;
}

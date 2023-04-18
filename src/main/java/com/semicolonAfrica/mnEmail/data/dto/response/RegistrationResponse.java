package com.semicolonAfrica.mnEmail.data.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class RegistrationResponse {
    private HttpStatus status;
    private String message;
}

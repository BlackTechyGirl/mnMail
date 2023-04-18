package com.semicolonAfrica.mnEmail.data.dto.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class MessageResponse {
    private String message;
    private HttpStatus httpStatus;
}

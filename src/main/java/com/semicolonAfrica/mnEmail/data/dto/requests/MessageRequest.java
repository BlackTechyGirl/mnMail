package com.semicolonAfrica.mnEmail.data.dto.requests;

import com.semicolonAfrica.mnEmail.data.model.Contact;
import lombok.Builder;
import lombok.Data;

import java.io.File;

@Data
public class MessageRequest {
    private String sender;
    private String recipient;
    private String subject;
    private String body;
    private File attachment;
}

package com.semicolonAfrica.mnEmail.services;

import com.semicolonAfrica.mnEmail.data.dto.requests.MessageRequest;
import jakarta.mail.MessagingException;
import org.springframework.scheduling.annotation.Async;

public interface MessageService {
    @Async
    void send(MessageRequest messageRequest) throws MessagingException;
}

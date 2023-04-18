package com.semicolonAfrica.mnEmail.data.dto.requests;

import com.semicolonAfrica.mnEmail.data.model.Contact;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddContactRequest {
    private Long userId;
    private Contact contact;
}

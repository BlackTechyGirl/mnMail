package com.semicolonAfrica.mnEmail.services;

import com.semicolonAfrica.mnEmail.data.model.Contact;

import java.util.Optional;

public interface ContactService {
    void addContact(Contact contact);
    Optional<Contact> findByEmailAddress(String emailAddress);
}

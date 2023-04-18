package com.semicolonAfrica.mnEmail.data.repository;

import com.semicolonAfrica.mnEmail.data.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepo extends JpaRepository<Contact, Long> {
    Optional<Contact> findByEmailAddress(String emailAddress);
}

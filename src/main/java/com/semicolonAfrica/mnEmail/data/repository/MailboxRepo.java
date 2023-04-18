package com.semicolonAfrica.mnEmail.data.repository;

import com.semicolonAfrica.mnEmail.data.model.MailBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailboxRepo extends JpaRepository<MailBox, Long> {
}

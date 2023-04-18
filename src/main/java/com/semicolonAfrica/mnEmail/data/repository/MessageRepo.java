package com.semicolonAfrica.mnEmail.data.repository;

import com.semicolonAfrica.mnEmail.data.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}

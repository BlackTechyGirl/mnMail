package com.semicolonAfrica.mnEmail.data.repository;

import com.semicolonAfrica.mnEmail.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmailAddress(String emailAddress);
}

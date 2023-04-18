package com.semicolonAfrica.mnEmail.services;

import com.semicolonAfrica.mnEmail.data.model.MailBox;
import com.semicolonAfrica.mnEmail.data.repository.MailboxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailboxServiceImpl implements MailboxService{
    @Autowired
    private MailboxRepo mailBoxRepo;
    @Override
    public void save(MailBox mailBox) {
        mailBoxRepo.save(mailBox);
    }
}

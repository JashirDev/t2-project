package com.example.correspondence.business.impl;

import com.example.correspondence.business.MailService;
import com.example.correspondence.model.MailRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MailServiceImpl implements MailService {

    @Override
    public Mono<Void> sendMail(MailRequest request) {
        return null;
    }
}

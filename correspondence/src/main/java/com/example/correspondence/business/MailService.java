package com.example.correspondence.business;

import com.example.correspondence.model.MailRequest;
import reactor.core.publisher.Mono;

public interface MailService {
    Mono<Void> sendMail(MailRequest request);
}

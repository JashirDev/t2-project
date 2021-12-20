package com.example.correspondence.business;

import com.example.correspondence.model.MailRequest;
import com.example.correspondence.model.Response;
import reactor.core.publisher.Mono;

public interface MailService {
    Mono<Response> sendMail(MailRequest request);
}

package com.example.usersecurity.business;

import com.example.usersecurity.model.Response;
import reactor.core.publisher.Mono;

public interface SecurityPerson {

    Mono<Response> getPerson(String dni);
}

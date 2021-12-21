package com.example.usersecurity.web;

import com.example.usersecurity.business.SecurityPerson;
import com.example.usersecurity.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/user-security")
@RequiredArgsConstructor
public class SecurityPersonController {

    private final SecurityPerson service;

    @GetMapping(value = "/{dni}")
    public Mono<Response> getStudent(@PathVariable  String dni){
        return  service.getPerson(dni);
    }

}

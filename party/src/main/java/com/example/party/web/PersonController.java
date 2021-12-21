package com.example.party.web;

import com.example.party.business.PartyServices;
import com.example.party.model.api.PartyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/party")
@RequiredArgsConstructor
public class PersonController {

    private final PartyServices service;

    @PostMapping
    public Mono<Void> createStudent(@RequestBody PartyRequest request){
        return service.createPerson(request);
    }

    @GetMapping(value = "/{dni}")
    public Mono<PartyRequest> getStudent(@PathVariable  String dni){
        return  service.getPerson(dni);
    }


}

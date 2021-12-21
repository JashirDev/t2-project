package com.example.party.business.impl;

import com.example.party.business.PartyServices;
import com.example.party.model.api.PartyRequest;
import com.example.party.repository.PersonRepository;
import com.example.party.util.Director;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class PartyServiceImpl implements PartyServices {

    private final PersonRepository repository;

    @Override
    public Mono<Void> createPerson(PartyRequest request) {
        log.info("Inicia creacion de persona");
        return Mono.fromCallable(()->Director.buildJpaModel(request))
                .map(repository::save)
                .then();
    }

    @Override
    public Mono<PartyRequest> getPerson(String dni) {
        log.info("Inicia consulta de persona");
        return Mono.fromCallable(()-> repository.findByDni(dni))
                .doOnSuccess(person -> log.info("existe el dato: "+person.isPresent()))
                .map(person -> person.isPresent()?
                        Director.modelToResponse(person.get()): PartyRequest.builder().build())
                ;

    }
}

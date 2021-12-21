package com.example.party.business.impl;

import com.example.party.business.PartyServices;
import com.example.party.model.api.PartyRequest;
import com.example.party.repository.PersonRepository;
import com.example.party.util.Director;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyServices {

    private final PersonRepository repository;

    @Override
    public Mono<Void> createPerson(PartyRequest request) {
        return Mono.fromCallable(()->Director.buildJpaModel(request))
                .map(repository::save)
                .then();
    }

    @Override
    public Mono<PartyRequest> getPerson(String dni) {
        return Mono.fromCallable(()-> repository.findByDni(dni))
                .map(person -> person.isPresent()?
                        Director.modelToResponse(person.get()): PartyRequest.builder().build());

    }
}

package com.example.party.business;

import com.example.party.model.api.PartyRequest;
import reactor.core.publisher.Mono;

public interface PartyServices {

    Mono<Void> createPerson(PartyRequest request);

    Mono<PartyRequest> getPerson(String dni);
}

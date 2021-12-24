package com.example.studentenrollment.enrollment.connectorapi.party.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "party",url = "http://localhost:9006")
@Component
public interface PartyApi {

    @RequestMapping(method = RequestMethod.POST,value = "/party")
    Mono<Void> createPerson(@RequestBody PartyRequest request);



    @RequestMapping(method = RequestMethod.GET,value = "/party/{dni}")
    Mono<PartyRequest> searchPerson(@PathVariable String dni);
}

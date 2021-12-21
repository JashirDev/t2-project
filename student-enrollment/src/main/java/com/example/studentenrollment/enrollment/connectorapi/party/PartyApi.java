package com.example.studentenrollment.enrollment.connectorapi.party;

import com.example.studentenrollment.enrollment.model.StudenRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "party",url = "http://localhost:9006")
public interface PartyApi {

    @RequestMapping(method = RequestMethod.POST,value = "/party")
    Mono<Void> createStudent(@RequestBody PartyRequest request);
}

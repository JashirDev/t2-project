package com.example.studentenrollment.enrollment.connectorapi.usersecurity.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "user-security",url = "http://localhost:9007")
@Component
public interface UserPersonApi {

    @RequestMapping(method = RequestMethod.GET,value = "/user-security/{dni}")
    Mono<SecurityResponse> getConsult(@PathVariable String dni);
}

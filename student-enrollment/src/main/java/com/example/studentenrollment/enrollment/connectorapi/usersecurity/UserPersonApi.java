package com.example.studentenrollment.enrollment.connectorapi.usersecurity;

import com.example.studentenrollment.enrollment.model.StudenRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "user-security",url = "http://localhost:9007")
public interface UserPersonApi {

    @RequestMapping(method = RequestMethod.GET,value = "/user-security/{dni}")
    Mono<Response> getConsult(@PathVariable String dni);
}

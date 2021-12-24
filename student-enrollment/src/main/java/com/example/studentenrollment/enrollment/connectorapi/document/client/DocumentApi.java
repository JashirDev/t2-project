package com.example.studentenrollment.enrollment.connectorapi.document.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "document-service",url = "http://localhost:9004")
@Component
public interface DocumentApi {

    @RequestMapping(method = RequestMethod.POST,value = "/document-service")
    Mono<Void> createStudent(@RequestBody DocumentRequest request);
}

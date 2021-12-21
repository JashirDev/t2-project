package com.example.studentenrollment.enrollment.connectorapi.correspondence.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "correspondence",url = "http://localhost:9005")
@Component
public interface CorrespondenceApi {
    @RequestMapping(method = RequestMethod.POST,value = "/correspondence")
    Mono<Response> sendMailFrom(@RequestBody MailRequest request);
}

package com.example.studentenrollment.enrollment.connectorapi.correspondence;

import com.example.studentenrollment.enrollment.model.StudenRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "correspondence",url = "http://localhost:9005")
public interface CorrespondenceApi {
    @RequestMapping(method = RequestMethod.POST,value = "/correpondence")
    Mono<Response> sendMailFrom(@RequestBody MailRequest request);
}

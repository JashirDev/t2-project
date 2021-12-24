package com.example.studentenrollment.enrollment.connectorapi.enrollmentprocessconector;


import com.example.studentenrollment.enrollment.model.StudenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "enrollment-process",url = "http://localhost:9001")
@Component
public interface EnrollmentProcessApi {

    @RequestMapping(method = RequestMethod.POST,value = "/student")
     Mono<Void> createStudent(@RequestBody StudenRequest request);
}

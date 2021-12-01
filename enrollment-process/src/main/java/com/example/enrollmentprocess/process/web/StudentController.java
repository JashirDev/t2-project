package com.example.enrollmentprocess.process.web;

import com.example.enrollmentprocess.process.business.StudentService;
import com.example.enrollmentprocess.process.model.api.StudenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @PostMapping
    public Mono<Void> createStudent(@RequestBody StudenRequest request){
        return service.createStudent(request);
    }

}

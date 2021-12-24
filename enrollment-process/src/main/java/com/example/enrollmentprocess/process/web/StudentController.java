package com.example.enrollmentprocess.process.web;

import com.example.enrollmentprocess.process.business.StudentService;
import com.example.enrollmentprocess.process.model.api.StudenRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/student")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService service;

    @PostMapping
    public Mono<Void> createStudent(@RequestBody StudenRequest request){
        log.info("inicio");
        return service.createStudent(request);
    }

    @GetMapping(value = "/{name}")
    public Mono<StudenRequest> getStudent(@PathVariable  String name){
        return  service.getSingleStudent(name);
    }

    @GetMapping
    public Flux<StudenRequest> getStudents(){
        return  service.getStudents();
    }

}

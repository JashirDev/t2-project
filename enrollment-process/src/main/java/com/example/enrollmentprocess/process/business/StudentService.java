package com.example.enrollmentprocess.process.business;

import com.example.enrollmentprocess.process.model.api.StudenRequest;
import com.example.enrollmentprocess.process.model.jpamodel.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

    Mono<Void> createStudent(StudenRequest request);

    Mono<StudenRequest> getSingleStudent(String name);

    Flux<StudenRequest> getStudents();

}

package com.example.enrollmentprocess.process.business;

import com.example.enrollmentprocess.process.model.api.StudenRequest;
import reactor.core.publisher.Mono;

public interface StudentService {
    Mono<Void> createStudent(StudenRequest request);

}

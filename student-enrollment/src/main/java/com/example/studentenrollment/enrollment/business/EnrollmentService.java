package com.example.studentenrollment.enrollment.business;

import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import org.springframework.boot.CommandLineRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EnrollmentService {

    Mono<Void> enrollStudent(StudentDataRequest request);
    Flux<StudentDataRequest> getAllStudents();


}

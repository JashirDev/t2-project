package com.example.studentenrollment.enrollment.business.impl;

import com.example.studentenrollment.enrollment.business.EnrollmentService;
import com.example.studentenrollment.enrollment.business.builder.EnrollmentProcessBuilder;
import com.example.studentenrollment.enrollment.connectorapi.enrollmentprocessconector.EnrollmentProcessApi;
import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentProcessBuilder enrollmentBuilder;
    private final EnrollmentProcessApi api;

    @Override
    public Mono<Void> enrollStudent(StudentDataRequest request) {
        return Mono.fromCallable(()-> request)
                .map(enrollmentBuilder::buildEnrollmentProcessRequest)
                .flatMap(api::createStudent)
                ;
    }

    @Override
    public Flux<StudentDataRequest> getAllStudents() {
        return null;
    }

}

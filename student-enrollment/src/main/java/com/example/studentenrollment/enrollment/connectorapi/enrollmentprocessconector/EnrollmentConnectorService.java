package com.example.studentenrollment.enrollment.connectorapi.enrollmentprocessconector;

import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import reactor.core.publisher.Mono;

public interface EnrollmentConnectorService {
    /*Mono<Void>  registerStudent(StudentDataRequest request);*/
    Mono<StudentDataRequest>  registerStudent(StudentDataRequest request);
}

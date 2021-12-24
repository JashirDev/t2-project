package com.example.studentenrollment.enrollment.connectorapi.correspondence;

import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import reactor.core.publisher.Mono;

public interface CorrespondenceConnector {

    Mono<StudentDataRequest> sendEmail(StudentDataRequest request);

}

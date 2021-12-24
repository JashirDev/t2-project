package com.example.studentenrollment.enrollment.connectorapi.usersecurity;

import com.example.studentenrollment.enrollment.connectorapi.usersecurity.client.SecurityResponse;
import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import reactor.core.publisher.Mono;

public interface UserSecurityConnector {

    Mono<StudentDataRequest> searchInReniec(StudentDataRequest request);
}

package com.example.studentenrollment.enrollment.connectorapi.enrollmentprocessconector;

import com.example.studentenrollment.enrollment.business.builder.EnrollmentProcessBuilder;
import com.example.studentenrollment.enrollment.model.StudenRequest;
import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class EnrollmentConnectorServiceImpl implements  EnrollmentConnectorService{

    private final EnrollmentProcessApi api;

    private final EnrollmentProcessBuilder builder;

    @Autowired
    public EnrollmentConnectorServiceImpl(EnrollmentProcessApi api, EnrollmentProcessBuilder builder) {
        this.api = api;
        this.builder = builder;
    }

   /* @Override
    public Mono<Void> registerStudent(StudentDataRequest request) {

        return api.createStudent(builder.buildEnrollmentProcessRequest(request));
    }*/

    @Override
    public Mono<StudentDataRequest> registerStudent(StudentDataRequest request) {

        return api.createStudent(builder.buildEnrollmentProcessRequest(request))
                .thenReturn(request);
    }
}

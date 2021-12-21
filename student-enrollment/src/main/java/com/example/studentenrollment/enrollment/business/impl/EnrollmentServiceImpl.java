package com.example.studentenrollment.enrollment.business.impl;

import com.example.studentenrollment.enrollment.business.EnrollmentService;
import com.example.studentenrollment.enrollment.business.builder.EnrollmentProcessBuilder;
import com.example.studentenrollment.enrollment.connectorapi.enrollmentprocessconector.EnrollmentConnectorService;
import com.example.studentenrollment.enrollment.connectorapi.enrollmentprocessconector.EnrollmentProcessApi;
import com.example.studentenrollment.enrollment.connectorapi.party.PartyConnector;
import com.example.studentenrollment.enrollment.connectorapi.party.client.PartyRequest;
import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Slf4j
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentProcessBuilder enrollmentBuilder;
    private final EnrollmentProcessApi api;
    private final EnrollmentConnectorService enrolmentConnector;
    private final PartyConnector partyConnector;

   /* @Autowired
    public EnrollmentServiceImpl(EnrollmentProcessBuilder enrollmentBuilder, EnrollmentProcessApi api, EnrollmentConnectorService enrolmentConnector) {
        this.enrollmentBuilder = enrollmentBuilder;
        this.api = api;
        this.enrolmentConnector = enrolmentConnector;
    }*/

    @Autowired
    public EnrollmentServiceImpl(EnrollmentProcessBuilder enrollmentBuilder, EnrollmentProcessApi api, EnrollmentConnectorService enrolmentConnector, PartyConnector partyConnector) {
        this.enrollmentBuilder = enrollmentBuilder;
        this.api = api;
        this.enrolmentConnector = enrolmentConnector;
        this.partyConnector = partyConnector;
    }
    /* @Override
    public Mono<Void> enrollStudent(StudentDataRequest request) {
        log.info("inicia creacion de estudiante desde ms experiencia");
        return Mono.fromCallable(()-> request)
                .map(enrollmentBuilder::buildEnrollmentProcessRequest)
                .flatMap(api::createStudent)
                ;
    }*/

    @Override
    public Mono<Void> enrollStudent(StudentDataRequest request) {
    log.info("inicia creacion de estudiante desde ms experiencia");
        return Mono.fromCallable(()-> request)
                .flatMap(partyConnector::searchDni)
                .map(partyRequestMono -> validateResponse(partyRequestMono,request)
                        )
                .flatMap(enrolmentConnector::registerStudent)
                .then()
                ;
    }

    @Override
    public Flux<StudentDataRequest> getAllStudents() {
        return null;
    }


    private StudentDataRequest validateResponse(PartyRequest partyResponse, StudentDataRequest request){
        if(partyResponse==null){
            return StudentDataRequest.builder().build();
        }else{
            return request;
        }

    }

}

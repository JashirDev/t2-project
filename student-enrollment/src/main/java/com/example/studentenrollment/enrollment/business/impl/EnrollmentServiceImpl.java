package com.example.studentenrollment.enrollment.business.impl;

import com.example.studentenrollment.enrollment.business.EnrollmentService;
import com.example.studentenrollment.enrollment.business.builder.EnrollmentProcessBuilder;
import com.example.studentenrollment.enrollment.connectorapi.enrollmentprocessconector.EnrollmentConnectorService;
import com.example.studentenrollment.enrollment.connectorapi.enrollmentprocessconector.EnrollmentProcessApi;
import com.example.studentenrollment.enrollment.connectorapi.party.PartyConnector;
import com.example.studentenrollment.enrollment.connectorapi.party.client.PartyRequest;
import com.example.studentenrollment.enrollment.connectorapi.usersecurity.UserSecurityConnector;
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
    private final UserSecurityConnector userSecurityConnector;


/* actual @Override
    @Autowired
    public EnrollmentServiceImpl(EnrollmentProcessBuilder enrollmentBuilder, EnrollmentProcessApi api, EnrollmentConnectorService enrolmentConnector, PartyConnector partyConnector) {
        this.enrollmentBuilder = enrollmentBuilder;
        this.api = api;
        this.enrolmentConnector = enrolmentConnector;
        this.partyConnector = partyConnector;
    }



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

    }*/


    public EnrollmentServiceImpl(EnrollmentProcessBuilder enrollmentBuilder, EnrollmentProcessApi api, EnrollmentConnectorService enrolmentConnector, PartyConnector partyConnector, UserSecurityConnector userSecurityConnector) {
        this.enrollmentBuilder = enrollmentBuilder;
        this.api = api;
        this.enrolmentConnector = enrolmentConnector;
        this.partyConnector = partyConnector;
        this.userSecurityConnector = userSecurityConnector;
    }

    @Override
    public Mono<Void> enrollStudent(StudentDataRequest request) {
        log.info("inicia creacion de estudiante desde ms experiencia");
        return Mono.fromCallable(()-> request)
                .flatMap(partyConnector::searchDni)
                .map(partyRequestMono -> validateResponse(partyRequestMono,request)
                )
                .flatMap(partyResult -> partyResult.getDni() == null ?
                        userSecurityConnector.searchInReniec(request)
                                .flatMap(partyConnector::createPerson):
                        Mono.fromCallable(()-> partyResult)

                        )
              //  .flatMap(partyConnector::createPerson)
                .flatMap(enrolmentConnector::registerStudent)
                .then()
                ;
    }

    @Override
    public Flux<StudentDataRequest> getAllStudents() {
        return null;
    }


    private StudentDataRequest validateResponse(PartyRequest partyResponse, StudentDataRequest request){
        if(partyResponse.getDni()==null){
            return StudentDataRequest.builder().build();
        }else{
            return request;
        }

    }

}

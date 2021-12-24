package com.example.studentenrollment.enrollment.connectorapi.party;

import com.example.studentenrollment.enrollment.connectorapi.party.client.PartyRequest;
import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import reactor.core.publisher.Mono;

public interface PartyConnector {

    Mono<PartyRequest> searchDni(StudentDataRequest request);

    Mono<StudentDataRequest> createPerson(StudentDataRequest request);
}

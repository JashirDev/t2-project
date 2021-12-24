package com.example.studentenrollment.enrollment.connectorapi.party;

import com.example.studentenrollment.enrollment.connectorapi.party.client.PartyApi;
import com.example.studentenrollment.enrollment.connectorapi.party.client.PartyRequest;
import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Slf4j
public class PartyConnectorImpl implements PartyConnector{

    private  final PartyApi apiService;

    @Autowired
    public PartyConnectorImpl(PartyApi apiService) {
        this.apiService = apiService;
    }

    @Override
    public Mono<PartyRequest> searchDni(StudentDataRequest request) {
        log.info("Inicia consulta de persona ");
        return apiService.searchPerson(request.getDni())
                .doOnSuccess(partyRequest -> log.info("dato existe"+partyRequest.getName()))
                //.map(partyRequest -> Objects.nonNull(partyRequest))
                ;
    }

    @Override
    public Mono<StudentDataRequest> createPerson(StudentDataRequest request) {
        log.info("Inicia cracion de cliente en party");
        return apiService.createPerson(PartyRequest.builder()
                        .name(request.getName())
                        .fatherName(request.getFatherLastName())
                        .motherName(request.getMotherLastName())
                        .dni(request.getDni())
                .build())
                .thenReturn(request);
    }
}

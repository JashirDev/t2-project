package com.example.studentenrollment.enrollment.connectorapi.correspondence;

import com.example.studentenrollment.enrollment.connectorapi.correspondence.client.CorrespondenceApi;
import com.example.studentenrollment.enrollment.connectorapi.correspondence.client.MailRequest;
import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CorrespondenceConnectorImpl implements  CorrespondenceConnector{

    private final CorrespondenceApi correspondenceApi;

    @Autowired
    public CorrespondenceConnectorImpl(CorrespondenceApi correspondenceApi) {
        this.correspondenceApi = correspondenceApi;
    }

    @Override
    public Mono<StudentDataRequest> sendEmail(StudentDataRequest request) {
        log.info("inicia envio de correos");
        return correspondenceApi.sendMailFrom(MailRequest.builder()
                        .to(request.getEmail())
                        .subject("Matricula virtual")
                        .text("Gracias por usasr nuestros servicios de matricula virtual, useted ya se encuentra registrado")
                .build())
                .map(response -> request);
    }
}

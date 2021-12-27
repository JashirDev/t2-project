package com.example.correspondence.business.impl;

import com.example.correspondence.business.MailService;
import com.example.correspondence.mailing.MyMailService;
import com.example.correspondence.model.MailRequest;
import com.example.correspondence.model.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Service
@Slf4j
public class MailServiceImpl implements MailService {
    @Autowired
    private MyMailService mailService;

    @Override
    public Mono<Response> sendMail(MailRequest request) {
        log.info("inicia envio de correo");
        Instant star= Instant.now();
        return Mono.fromCallable(()-> request)
                .map(request1 -> {

                    mailService.sendEmail(request1.getTo(),request1.getSubject(),request1.getText());
                    return Response.builder().message("Operacion exitosa").build();
                })
                .doOnError(throwable -> Response.builder().message("Operacion fallida").build())
                .doFinally(signalType -> log.info("TIEMPO DE CORREO "+Duration.between(star,Instant.now()).getSeconds()));
    }

}

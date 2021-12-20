package com.example.correspondence.business.impl;

import com.example.correspondence.business.MailService;
import com.example.correspondence.mailing.MyMailService;
import com.example.correspondence.model.MailRequest;
import com.example.correspondence.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private MyMailService mailService;

    @Override
    public Mono<Response> sendMail(MailRequest request) {
        return Mono.fromCallable(()-> request)
                //.map(mailRq -> sendEmail(mailRq))
                .map(request1 -> {

                    mailService.sendEmail(request1.getTo(),request1.getSubject(),request1.getText());
                    return Response.builder().message("Operacion exitosa").build();
                })
                .doOnError(throwable -> Response.builder().message("Operacion fallida").build());
    }

  /*  public Response sendEmail(MailRequest request){
        mailService= new MyMailService();
        mailService.sendEmail(request.getTo(),request.getSubject(),request.getText());
        return Response.builder().message("Operacion exitosa").build();
    }*/
}

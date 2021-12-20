package com.example.correspondence.web;

import com.example.correspondence.business.MailService;
import com.example.correspondence.model.MailRequest;
import com.example.correspondence.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/correspondence")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping
     Mono<Response> sendEmail(@RequestBody MailRequest request){
        return mailService.sendMail(request);
    }
}

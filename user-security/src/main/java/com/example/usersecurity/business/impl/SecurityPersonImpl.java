package com.example.usersecurity.business.impl;

import com.example.usersecurity.business.SecurityPerson;
import com.example.usersecurity.model.Response;
import com.example.usersecurity.reniecapi.ApiConection;
import com.example.usersecurity.reniecapi.Conection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SecurityPersonImpl implements SecurityPerson {

   /* private Conection reniecapi;


    @Override
    public Mono<Response> getPerson(String dni) {
        return Mono.fromCallable(()-> reniecapi.requestDni(dni))
                .map(s -> Objects.nonNull(s)?
                        Response.builder().code("1").description("Operacion exitosa").build():
                                Response.builder().code("2").description("Operacion fallida").build()
                        );
    }*/

    private  final ApiConection reniecApi;

    @Override
    public Mono<Response> getPerson(String dni) {
        return Mono.fromCallable(()-> reniecApi.findByDni(dni))
                .map(person -> person.isPresent()?
                                Response.builder().code("1").description("Operacion exitosa").build():
                                Response.builder().code("2").description("Operacion fallida").build()
                        );
    }
}

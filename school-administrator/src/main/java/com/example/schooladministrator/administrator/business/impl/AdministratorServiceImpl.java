package com.example.schooladministrator.administrator.business.impl;

import com.example.schooladministrator.administrator.business.AdministratorService;
import com.example.schooladministrator.administrator.model.api.SchoolRequest;
import com.example.schooladministrator.administrator.model.jpamodel.School;
import com.example.schooladministrator.administrator.repository.SchoolRepository;
import com.example.schooladministrator.administrator.util.Director;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RequiredArgsConstructor
public class AdministratorServiceImpl implements AdministratorService {

    private final SchoolRepository repository;


    @Override
    public Mono<Void> createSchool(SchoolRequest request) {
        return Mono.fromCallable(()-> request)
                .map(Director::buildSchoolData)
                .map(repository::save)
                .then();
    }

    @Override
    public Flux<SchoolRequest> getSchoolsInformation() {
        return Flux.fromIterable( repository.findAll())
                .map(Director::buildSchoolResponse);
    }

    @Override
    public Mono<SchoolRequest> getSingleSchoolInformation(String name) {
        return Mono.fromCallable(() -> repository.findByName(name))
                .map(response->response.isPresent()? new SchoolRequest() : Director.buildSchoolResponse(response.get()));
    }

    @Override
    public Mono<Void> updateSchool(SchoolRequest request) {
        return Mono.fromCallable(()-> request)
                .map(schoolRequest-> repository.findByName(schoolRequest.getSchoolData().getName()))
                .map(school -> Director.updateSchool(school.get(),request))
                .then();
    }

    @Override
    public Mono<Void> deleteSchool(String name) {
        return null;
    }



}

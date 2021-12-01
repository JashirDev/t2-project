package com.example.schooladministrator.administrator.business;

import com.example.schooladministrator.administrator.model.api.SchoolRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface AdministratorService {

    Mono<Void> createSchool(SchoolRequest request);

    Flux<SchoolRequest> getSchoolsInformation();

    Mono<SchoolRequest> getSingleSchoolInformation(String name);

    Mono<Void> updateSchool(SchoolRequest request);

    Mono<Void> deleteSchool(String name);


}

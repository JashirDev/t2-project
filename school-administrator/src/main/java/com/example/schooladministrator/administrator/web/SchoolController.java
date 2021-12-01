package com.example.schooladministrator.administrator.web;

import com.example.schooladministrator.administrator.business.AdministratorService;
import com.example.schooladministrator.administrator.model.api.SchoolRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/school")
public class SchoolController {


    private final AdministratorService service;

    @PostMapping
    Mono<Void>createSchool(SchoolRequest request){
        return service.createSchool(request);
    }

    @GetMapping(value = "/schoolName")
    Mono<SchoolRequest> getSingleSchool(String schoolName){
        return service.getSingleSchoolInformation(schoolName);
    }

    @GetMapping
    Flux<SchoolRequest> getSchools(){
        return service.getSchoolsInformation();
    }

}

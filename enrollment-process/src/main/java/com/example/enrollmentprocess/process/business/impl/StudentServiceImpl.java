package com.example.enrollmentprocess.process.business.impl;

import com.example.enrollmentprocess.process.business.StudentService;
import com.example.enrollmentprocess.process.model.api.StudenRequest;
import com.example.enrollmentprocess.process.repository.StudentRepository;
import com.example.enrollmentprocess.process.util.Director;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl  implements StudentService {

    private final StudentRepository repository;

    @Override
    public Mono<Void> createStudent(StudenRequest request) {
        return Mono.fromCallable(()-> Director.requestToModel(request))
                .map(repository::save)
                .then();
    }
}

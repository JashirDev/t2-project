package com.example.enrollmentprocess.process.business.impl;

import com.example.enrollmentprocess.process.business.StudentService;
import com.example.enrollmentprocess.process.model.api.StudenRequest;
import com.example.enrollmentprocess.process.model.jpamodel.Student;
import com.example.enrollmentprocess.process.repository.StudentRepository;
import com.example.enrollmentprocess.process.util.Director;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl  implements StudentService {

    private final StudentRepository repository;

    @Override
    public Mono<Void> createStudent(StudenRequest request) {
        log.info("inicia creacion de estudiante");
        return Mono.fromCallable(()-> Director.requestToModel(request))
                .map(repository::save)
                .then();
    }

    @Override
    public Mono<StudenRequest> getSingleStudent(String name) {
        return Mono.fromCallable(()-> repository.findByName(name))
                .map(student -> {
                    if (student.isPresent()){
                        return  Director.modelToResponse(student.get());
                    }else {
                        return new StudenRequest();
                    }
                });
    }

    @Override
    public Flux<StudenRequest> getStudents() {
        log.info("inicia obtencion de estudiantes");
        return Mono.fromCallable(repository::findAll)
                .flatMapMany(Flux::fromIterable)
                .map(Director::modelToResponse);
    }
}

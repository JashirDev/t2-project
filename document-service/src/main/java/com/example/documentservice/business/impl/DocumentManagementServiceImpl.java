package com.example.documentservice.business.impl;

import com.example.documentservice.business.DocumentManagementService;
import com.example.documentservice.model.api.DocumentRequest;
import com.example.documentservice.repository.DocumentRepository;
import com.example.documentservice.util.Director;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class DocumentManagementServiceImpl implements DocumentManagementService {
    final DocumentRepository repository;


    @Override
    public Mono<Void> createdFile(DocumentRequest request) {
        return Mono.fromCallable( ()-> Director.buildDocument(request))
                .map(repository::save)
                .then();
    }

    @Override
    public Flux<DocumentRequest> getAllDocument() {
        return Mono.fromCallable(repository::findAll)
                .flatMapMany(Flux::fromIterable)
                .map(Director::buildResponse);
    }

    @Override
    public Mono<DocumentRequest> getSingleDocument(String dni) {
        return Mono.fromCallable(()-> repository.findByDni(dni))
                .map(Director::buildResponse);
    }
}

package com.example.documentservice.business;

import com.example.documentservice.model.api.DocumentRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DocumentManagementService {
    Mono<Void> createdFile(DocumentRequest request);

    Flux<DocumentRequest> getAllDocument();

    Mono<DocumentRequest> getSingleDocument(String dni);
}

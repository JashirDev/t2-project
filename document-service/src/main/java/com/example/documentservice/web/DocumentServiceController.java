package com.example.documentservice.web;

import com.example.documentservice.business.DocumentManagementService;
import com.example.documentservice.model.api.DocumentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/document-service")
public class DocumentServiceController {

    private  final DocumentManagementService service;

    @PostMapping
    Mono<Void> createFile(@RequestBody DocumentRequest request){
        return service.createdFile(request);
    }

    @GetMapping(value = "/{dni}")
    Mono<DocumentRequest> getSingleDocument(@PathVariable  String dni){
        return service.getSingleDocument(dni);
    }

    @GetMapping
    Flux<DocumentRequest> getDocuments(){
        return service.getAllDocument();
    }

}

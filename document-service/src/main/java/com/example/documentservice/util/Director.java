package com.example.documentservice.util;

import com.example.documentservice.model.api.DocumentRequest;
import com.example.documentservice.model.jpa.Document;

import java.time.LocalDate;

public class Director {

    public static Document buildDocument(DocumentRequest request){
        return  Document.builder()
                .documentName(request.getDocumentName())
                .studentName(request.getStudentName())
                .file(request.getFile())
                .dni(request.getDni())
                .content(request.getContent())
                .createdDate(LocalDate.now())
                .build();
    }

    public static DocumentRequest buildResponse(Document response){

        return  DocumentRequest.builder()
                .documentName(response.getDocumentName())
                .studentName(response.getStudentName())
                .file(response.getFile())
                .content(response.getContent())
                .dni(response.getDni())
                .build();
    }
}

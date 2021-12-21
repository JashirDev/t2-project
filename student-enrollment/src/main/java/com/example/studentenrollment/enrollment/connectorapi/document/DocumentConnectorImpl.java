package com.example.studentenrollment.enrollment.connectorapi.document;


import com.example.studentenrollment.enrollment.connectorapi.document.client.DocumentApi;
import com.example.studentenrollment.enrollment.connectorapi.document.client.DocumentRequest;
import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class DocumentConnectorImpl implements  DocumentConnector{

    private  final DocumentApi documentApi;

    @Autowired
    public DocumentConnectorImpl(DocumentApi documentApi) {
        this.documentApi = documentApi;
    }

    @Override
    public Mono<StudentDataRequest> registerFiles(StudentDataRequest request) {
        log.info("inicia registro de documentos");
        return documentApi.createStudent(DocumentRequest.builder()
                        .studentName(request.getName()+" "+request.getFatherLastName()+" "+request.getMotherLastName())
                        .dni(request.getDni())
                        .content(request.getDocumentFile().getContent())
                        .file("pdf")
                        .documentName(request.getDocumentFile().getDocumentName())
                .build())
                .thenReturn(request);
    }
}

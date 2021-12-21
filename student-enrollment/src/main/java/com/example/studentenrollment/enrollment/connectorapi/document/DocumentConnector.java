package com.example.studentenrollment.enrollment.connectorapi.document;

import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


public interface DocumentConnector {

    Mono<StudentDataRequest> registerFiles(StudentDataRequest request);
}

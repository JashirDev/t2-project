package com.example.studentenrollment.enrollment.connectorapi.usersecurity;

import com.example.studentenrollment.enrollment.connectorapi.usersecurity.client.SecurityResponse;
import com.example.studentenrollment.enrollment.connectorapi.usersecurity.client.UserPersonApi;
import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserSecurityConnectorImpl implements  UserSecurityConnector{

    private  final UserPersonApi apiService;

    @Autowired
    public UserSecurityConnectorImpl(UserPersonApi apiService) {
        this.apiService = apiService;
    }

    @Override
    public Mono<StudentDataRequest> searchInReniec(StudentDataRequest request) {
        log.info("inicia consulta a RENIEC");
        return apiService.getConsult(request.getDni())
                .map(securityResponse -> request)
                .doOnSuccess(request1 -> log.info("finaliza conuslta de reinec"))
                ;
    }
}

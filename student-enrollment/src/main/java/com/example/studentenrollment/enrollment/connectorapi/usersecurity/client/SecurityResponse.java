package com.example.studentenrollment.enrollment.connectorapi.usersecurity.client;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityResponse {

    private String code;
    private String description;
}

package com.example.studentenrollment.enrollment.connectorapi.correspondence.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MailRequest {

    private String subject;

    private String to;

    private String text;
}

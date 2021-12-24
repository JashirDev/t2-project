package com.example.studentenrollment.enrollment.connectorapi.party.client;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PartyRequest {

    private String dni;

    private String name;

    private String fatherName;

    private String motherName;
}

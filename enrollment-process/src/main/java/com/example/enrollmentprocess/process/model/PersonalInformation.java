package com.example.enrollmentprocess.process.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInformation {

    private String name;

    private String fatherLastName;

    private String motherLastName;

    private Integer age;

    private Identification identification;

}

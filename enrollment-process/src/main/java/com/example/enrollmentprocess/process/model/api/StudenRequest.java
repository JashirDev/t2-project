package com.example.enrollmentprocess.process.model.api;

import com.example.enrollmentprocess.process.model.PersonalInformation;
import com.example.enrollmentprocess.process.model.StudentInformation;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudenRequest {

    private StudentInformation studentIdentification;

    private PersonalInformation personalInformation;
}

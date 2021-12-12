package com.example.studentenrollment.enrollment.model;

import com.example.studentenrollment.enrollment.model.PersonalInformation;
import com.example.studentenrollment.enrollment.model.StudentInformation;
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

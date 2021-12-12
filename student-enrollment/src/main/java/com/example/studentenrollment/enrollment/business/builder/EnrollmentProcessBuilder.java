package com.example.studentenrollment.enrollment.business.builder;

import com.example.studentenrollment.enrollment.model.Identification;
import com.example.studentenrollment.enrollment.model.PersonalInformation;
import com.example.studentenrollment.enrollment.model.StudenRequest;
import com.example.studentenrollment.enrollment.model.StudentInformation;
import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentProcessBuilder {



    public  StudenRequest buildEnrollmentProcessRequest(StudentDataRequest request){
        return StudenRequest.builder()
                .personalInformation(PersonalInformation.builder()
                        .name(request.getName())
                        .fatherLastName(request.getFatherLastName())
                        .motherLastName(request.getMotherLastName())
                        .age(request.getAge())
                        .identification(Identification.builder()
                                .dni(request.getDni())
                                .build())
                        .build())
                .studentIdentification(StudentInformation.builder()
                        .grade(request.getGrade())
                        .build())
                .build();
    }
}

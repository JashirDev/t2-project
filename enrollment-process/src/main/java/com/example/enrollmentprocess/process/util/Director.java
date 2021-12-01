package com.example.enrollmentprocess.process.util;

import com.example.enrollmentprocess.process.model.Identification;
import com.example.enrollmentprocess.process.model.PersonalInformation;
import com.example.enrollmentprocess.process.model.StudentInformation;
import com.example.enrollmentprocess.process.model.api.StudenRequest;
import com.example.enrollmentprocess.process.model.jpamodel.Student;

import java.time.LocalDate;

public class Director {

    public  static Student requestToModel(StudenRequest request){
        return Student.builder()
               .name(request.getPersonalInformation().getName())
                .fatherLastName(request.getPersonalInformation().getFatherLastName())
                 .motherLastName(request.getPersonalInformation().getMotherLastName())
                .age(request.getPersonalInformation().getAge())
               .identi(request.getPersonalInformation().getIdentification().getDni())
                .grade(request.getStudentIdentification().getGrade())
                .enrollmentDate(LocalDate.now())
                .build();

    }

    public static StudenRequest modelToResponse(Student model){
        return  StudenRequest.builder()
                .personalInformation(PersonalInformation.builder()
                        .name(model.getName())
                        .fatherLastName(model.getFatherLastName())
                        .motherLastName(model.getMotherLastName())
                        .age(model.getAge())
                        .identification(Identification.builder()
                                .dni(model.getIdenti())
                                .build())
                        .build())
                .studentIdentification(StudentInformation.builder()
                        .grade(model.getGrade())
                        .build())
                .build();

    }
}

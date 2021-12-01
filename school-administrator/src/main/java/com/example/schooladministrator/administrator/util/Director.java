package com.example.schooladministrator.administrator.util;

import com.example.schooladministrator.administrator.model.SchoolData;
import com.example.schooladministrator.administrator.model.api.SchoolRequest;
import com.example.schooladministrator.administrator.model.jpamodel.School;

import java.time.LocalDate;

public class Director {
    public static School buildSchoolData(SchoolRequest request){

        return  School.builder()
                .name(request.getSchoolData().getName())
                .directorName(request.getSchoolData().getDirectorName())
                .direction(request.getSchoolData().getDirection())
                .teacherNumber(request.getSchoolData().getTeacherNumber())
                .studentNumber(request.getSchoolData().getStudentNumber())
                .createdDate(LocalDate.now())
                .build();
    }

    public static SchoolRequest buildSchoolResponse(School response){
        return SchoolRequest.builder()
                .schoolData(SchoolData.builder()
                        .name(response.getName())
                        .directorName(response.getDirectorName())
                        .direction(response.getDirection())
                        .teacherNumber(response.getTeacherNumber())
                        .studentNumber(response.getStudentNumber())
                        .build())
                .build();
    }

    public static School updateSchool(School schoolUpdate,SchoolRequest request){

        if(request.getSchoolData().getDirectorName()!=null){
            schoolUpdate.setDirectorName(request.getSchoolData().getDirectorName());
        }
        if(request.getSchoolData().getDirection()!=null){
            schoolUpdate.setDirection(request.getSchoolData().getDirection());
        }
        if(request.getSchoolData().getStudentNumber()!=null){
            schoolUpdate.setStudentNumber(request.getSchoolData().getStudentNumber());
        }
        if(request.getSchoolData().getTeacherNumber()!=null){
            schoolUpdate.setTeacherNumber(request.getSchoolData().getTeacherNumber());
        }
       return schoolUpdate;

    }


}

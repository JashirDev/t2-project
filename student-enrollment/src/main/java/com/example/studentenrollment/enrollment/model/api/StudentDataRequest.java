package com.example.studentenrollment.enrollment.model.api;

import com.example.studentenrollment.enrollment.model.DocumentData;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDataRequest {

    private String name;

    private String fatherLastName;

    private String motherLastName;

    private Integer age;

    private  String dni;

    private  String grade;

    private String email;

    private DocumentData documentFile;
}

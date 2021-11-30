package com.example.schooladministrator.administrator.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolData {

    private String name;

    private String directorName;

    private String direction;

    private Integer teacherNumber;

    private Integer studentNumber;

}

package com.example.schooladministrator.administrator.model.jpamodel;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "School")
public class School {

    private  Long schoolId;

    private String name;

    private String directorName;

    private String direction;

    private Integer teacherNumber;

    private Integer studentNumber;

    private LocalDate createdDate;

    private LocalDate lastModifiedDate;

}

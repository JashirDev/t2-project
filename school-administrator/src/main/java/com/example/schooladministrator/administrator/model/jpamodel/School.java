package com.example.schooladministrator.administrator.model.jpamodel;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "School")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long schoolId;

    @Column(name = "Name")
    private String name;

    @Column(name = "DirectorName")
    private String directorName;

    @Column(name = "Direction")
    private String direction;

    @Column(name = "TeacherNumber")
    private Integer teacherNumber;

    @Column(name = "StudentNumber")
    private Integer studentNumber;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "LastModifiedDate")
    private LocalDate lastModifiedDate;

}

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
    @Column(name = "school_id")
    private  Long schoolId;

    @Column(name = "Name")
    private String name;

    @Column(name = "director_name")
    private String directorName;

    @Column(name = "direction")
    private String direction;

    @Column(name = "teacher_number")
    private Integer teacherNumber;

    @Column(name = "student_number")
    private Integer studentNumber;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "last_modified_date")
    private LocalDate lastModifiedDate;

}

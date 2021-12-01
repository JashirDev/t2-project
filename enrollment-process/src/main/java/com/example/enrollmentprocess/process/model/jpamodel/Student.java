package com.example.enrollmentprocess.process.model.jpamodel;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "students_id")
    private Long studenstId;

    @Column(name = "Name",nullable = false)
    private String name;

   @Column(name = "father_last_name",nullable = false)
    private String fatherLastName;

    @Column(name = "mother_last_name",nullable = false)
    private String motherLastName;

    @Column(name = "age",nullable = false)
    private Integer age;

    @Column(name = "grade",nullable = false)
    private String grade;

    @Column(name = "identi",nullable = false)
    private String identi;

    @Column(name = "enrollment_date",nullable = false)
    private LocalDate enrollmentDate ;

    @Column(name = "last_enrollment_date")
    private LocalDate lastEnrollmentDate;
}

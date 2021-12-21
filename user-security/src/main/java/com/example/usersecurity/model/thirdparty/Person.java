package com.example.usersecurity.model.thirdparty;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "father_last_name",nullable = false)
    private String fatherLastName;

    @Column(name = "mother_last_name",nullable = false)
    private String motherLastName;

    @Column(name = "dni",nullable = false)
    private String dni;

    @Column(name = "created_date",nullable = false)
    private LocalDate createdDate;
}

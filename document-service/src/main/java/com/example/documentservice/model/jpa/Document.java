package com.example.documentservice.model.jpa;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long documentId;


    @Column(name = "document_name")
    private String documentName;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "file")
    private String file;

    @Column(name = "content")
    private String content;

    @Column(name = "dni")
    private String dni;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "last_modified_date")
    private LocalDate lastModifiedDate;
}

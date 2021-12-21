package com.example.studentenrollment.enrollment.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentData {
    private  String documentName;
    private  String content;
}

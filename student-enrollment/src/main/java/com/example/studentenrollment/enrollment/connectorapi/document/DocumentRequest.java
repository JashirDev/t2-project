package com.example.studentenrollment.enrollment.connectorapi.document;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentRequest {

    private String documentName;

    private String studentName;

    private String file;

    private String content;

    private String dni;
}

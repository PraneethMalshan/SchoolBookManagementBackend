package com.kdpm.schoolTextbookManagement.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private int studentId;
    private String fullName;
    private String grade;
    private String subjectStream;
    private String className;
    private String studentImage;
}

package com.kdpm.schoolTextbookManagement.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentUpdateDTO {
    private int studentId;
    private String fullName;
    private String grade;
    private String subjectStream;
    private String className;
    private String studentImage;
}

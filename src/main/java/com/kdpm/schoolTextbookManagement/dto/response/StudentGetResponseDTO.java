package com.kdpm.schoolTextbookManagement.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentGetResponseDTO {
    private int studentId;
    private String fullName;
    private String grade;
    private String subjectStream;
    private String className;
    private String studentImage;

}

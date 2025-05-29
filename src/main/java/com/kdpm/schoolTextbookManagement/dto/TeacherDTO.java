package com.kdpm.schoolTextbookManagement.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDTO {
    private Long teacherId;
    private String fullName;
    private String subject;
    private String grade;
    private String teacherImage;
}

package com.kdpm.schoolTextbookManagement.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDTO {
    private int teacherId;
    private String fullName;
    private String subject;
    private String grade;
    private String teacherImage;
}

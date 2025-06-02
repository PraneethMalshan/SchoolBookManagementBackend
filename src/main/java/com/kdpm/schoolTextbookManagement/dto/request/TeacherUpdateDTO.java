package com.kdpm.schoolTextbookManagement.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherUpdateDTO {
    private int teacherId;
    private String fullName;
    private String subject;
    private String grade;
    private String teacherImage;

}

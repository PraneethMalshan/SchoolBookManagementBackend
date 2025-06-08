package com.kdpm.schoolTextbookManagement.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherGetResponseDTO {

    private int teacherId;
    private String fullName;
    private String subject;
    private String grade;
    private String teacherImage;

}

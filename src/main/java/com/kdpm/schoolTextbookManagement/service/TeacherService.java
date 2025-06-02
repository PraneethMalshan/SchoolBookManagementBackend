package com.kdpm.schoolTextbookManagement.service;

import com.kdpm.schoolTextbookManagement.dto.TeacherDTO;
import com.kdpm.schoolTextbookManagement.dto.request.TeacherUpdateDTO;

public interface TeacherService {
    String saveTeacher(TeacherDTO teacherDTO);

    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);
}

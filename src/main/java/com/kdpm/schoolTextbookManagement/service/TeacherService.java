package com.kdpm.schoolTextbookManagement.service;

import com.kdpm.schoolTextbookManagement.dto.TeacherDTO;
import com.kdpm.schoolTextbookManagement.dto.request.TeacherUpdateDTO;
import com.kdpm.schoolTextbookManagement.dto.response.TeacherGetResponseDTO;

import java.util.List;

public interface TeacherService {
    String saveTeacher(TeacherDTO teacherDTO);

    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

    List<TeacherGetResponseDTO> getTeacherById(int id);

    String deleteTeacher(int teacherId);
}

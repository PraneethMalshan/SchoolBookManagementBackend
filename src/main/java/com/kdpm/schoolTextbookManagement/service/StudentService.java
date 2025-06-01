package com.kdpm.schoolTextbookManagement.service;

import com.kdpm.schoolTextbookManagement.dto.StudentDTO;
import com.kdpm.schoolTextbookManagement.dto.request.StudentUpdateDTO;

public interface StudentService {
    String saveStudent(StudentDTO studentDTO);

    String updateStudent(StudentUpdateDTO studentUpdateDTO);

    StudentDTO getStudentById(int studentId);

}

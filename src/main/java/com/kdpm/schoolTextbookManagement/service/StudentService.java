package com.kdpm.schoolTextbookManagement.service;

import com.kdpm.schoolTextbookManagement.dto.StudentDTO;
import com.kdpm.schoolTextbookManagement.dto.request.StudentUpdateDTO;
import com.kdpm.schoolTextbookManagement.dto.response.StudentGetResponseDTO;

import java.util.List;

public interface StudentService {
    String saveStudent(StudentDTO studentDTO);

    String updateStudent(StudentUpdateDTO studentUpdateDTO);


    List<StudentGetResponseDTO> getStudentById(int studentId);

    String deleteStudent(int studentId);

    List<StudentDTO> getAllStudents();

}

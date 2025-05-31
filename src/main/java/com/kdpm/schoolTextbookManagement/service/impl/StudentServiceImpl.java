package com.kdpm.schoolTextbookManagement.service.impl;

import com.kdpm.schoolTextbookManagement.dto.StudentDTO;
import com.kdpm.schoolTextbookManagement.entity.Student;
import com.kdpm.schoolTextbookManagement.repository.StudentRepo;
import com.kdpm.schoolTextbookManagement.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        if (!studentRepo.existsById(student.getStudentId())){
            studentRepo.save(student);
            return student.getStudentId() + " Saved Successfully ";
        } else {
            throw  new RuntimeException("Already Added!!!");
        }
    }
}

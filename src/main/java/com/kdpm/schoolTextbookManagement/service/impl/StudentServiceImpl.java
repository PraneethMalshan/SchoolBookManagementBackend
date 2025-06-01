package com.kdpm.schoolTextbookManagement.service.impl;

import com.kdpm.schoolTextbookManagement.dto.StudentDTO;
import com.kdpm.schoolTextbookManagement.dto.request.StudentUpdateDTO;
import com.kdpm.schoolTextbookManagement.dto.response.StudentGetResponseDTO;
import com.kdpm.schoolTextbookManagement.entity.Student;
import com.kdpm.schoolTextbookManagement.repository.StudentRepo;
import com.kdpm.schoolTextbookManagement.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        if (studentRepo.existsById(studentUpdateDTO.getStudentId())){
            Student student = studentRepo.getReferenceById(studentUpdateDTO.getStudentId());

            student.setFullName(studentUpdateDTO.getFullName());
            student.setGrade(studentUpdateDTO.getGrade());
            student.setSubjectStream(studentUpdateDTO.getSubjectStream());
            student.setClassName(studentUpdateDTO.getClassName());
            student.setStudentImage(studentUpdateDTO.getStudentImage());

            studentRepo.save(student);
            return studentUpdateDTO.getFullName() + " Updated Successfully ";

        } else {
            throw new RuntimeException("No Data Found for that ID!!!");
        }
    }

    @Override
    public List<StudentGetResponseDTO> getStudentById(int studentId) {
        List<Student> students = studentRepo.findStudentByStudentId(studentId);
        if (!students.isEmpty()){
            List<StudentGetResponseDTO> studentGetResponseDTOS = students.stream()
                    .map(student -> modelMapper.map(student, StudentGetResponseDTO.class))
                    .collect(Collectors.toList());
            return studentGetResponseDTOS;
        } else {
            throw new RuntimeException("No Data Found for that ID!!!");
        }
    }

    @Override
    public String deleteStudent(int studentId) {
        if (studentRepo.existsById(studentId)){
            studentRepo.deleteStudentByStudentId(studentId);
            return " Deleted Successfully " + studentId;
        } else {
            throw new RuntimeException("No Student Found for that ID!!!");
        }
    }
}

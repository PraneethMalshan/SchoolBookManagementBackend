package com.kdpm.schoolTextbookManagement.service.impl;

import com.kdpm.schoolTextbookManagement.dto.TeacherDTO;
import com.kdpm.schoolTextbookManagement.dto.request.TeacherUpdateDTO;
import com.kdpm.schoolTextbookManagement.dto.response.TeacherGetResponseDTO;
import com.kdpm.schoolTextbookManagement.entity.Teacher;
import com.kdpm.schoolTextbookManagement.repository.TeacherRepo;
import com.kdpm.schoolTextbookManagement.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);
        if (!teacherRepo.existsById(teacher.getTeacherId())) {
            teacherRepo.save(teacher);
            return teacher.getTeacherId() + "Saved Successfully";
        } else {
            throw new RuntimeException("Teacher Already Exists!!!");
        }
    }

    @Override
    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
        if (teacherRepo.existsById(teacherUpdateDTO.getTeacherId())) {
            Teacher teacher = teacherRepo.getReferenceById(teacherUpdateDTO.getTeacherId());

            teacher.setFullName(teacherUpdateDTO.getFullName());
            teacher.setSubject(teacherUpdateDTO.getSubject());
            teacher.setGrade(teacherUpdateDTO.getGrade());
            teacher.setTeacherImage(teacherUpdateDTO.getTeacherImage());

            teacherRepo.save(teacher);
            return teacher.getFullName() + "Updated Successfully";

        } else {
            throw new RuntimeException("No Data Found for that ID!!!");
        }
    }

    @Override
    public List<TeacherGetResponseDTO> getTeacherById(int id) {
        List<Teacher> teachers = teacherRepo.findTeacherByTeacherId(id);
        if (!teachers.isEmpty()) {
            List<TeacherGetResponseDTO> teacherGetResponseDTOs = teachers.stream()
                    .map(teacher -> modelMapper.map(teacher, TeacherGetResponseDTO.class))
                    .collect(Collectors.toList());
                return teacherGetResponseDTOs;
        } else {
            throw new RuntimeException("No Data Found for that ID!!!");
        }
    }
}

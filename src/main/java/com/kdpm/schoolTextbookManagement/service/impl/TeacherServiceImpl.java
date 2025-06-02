package com.kdpm.schoolTextbookManagement.service.impl;

import com.kdpm.schoolTextbookManagement.dto.TeacherDTO;
import com.kdpm.schoolTextbookManagement.entity.Teacher;
import com.kdpm.schoolTextbookManagement.repository.TeacherRepo;
import com.kdpm.schoolTextbookManagement.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

package com.kdpm.schoolTextbookManagement.controller;

import com.kdpm.schoolTextbookManagement.dto.TeacherDTO;
import com.kdpm.schoolTextbookManagement.entity.Teacher;
import com.kdpm.schoolTextbookManagement.service.TeacherService;
import com.kdpm.schoolTextbookManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teachers")
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> addTeacher(@RequestBody TeacherDTO teacherDTO) {
        String message = teacherService.saveTeacher(teacherDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

}

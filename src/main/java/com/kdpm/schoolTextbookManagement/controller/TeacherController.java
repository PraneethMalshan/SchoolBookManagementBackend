package com.kdpm.schoolTextbookManagement.controller;

import com.kdpm.schoolTextbookManagement.dto.TeacherDTO;
import com.kdpm.schoolTextbookManagement.dto.request.TeacherUpdateDTO;
import com.kdpm.schoolTextbookManagement.dto.response.TeacherGetResponseDTO;
import com.kdpm.schoolTextbookManagement.entity.Teacher;
import com.kdpm.schoolTextbookManagement.service.TeacherService;
import com.kdpm.schoolTextbookManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO) {
        String message = teacherService.updateTeacher(teacherUpdateDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-by-id", params = "id")
    public ResponseEntity<StandardResponse> getTeacherById(@RequestParam(value = "id") int id) {
        List<TeacherGetResponseDTO> teacherGetResponseDTOS = teacherService.getTeacherById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Found", teacherGetResponseDTOS),
                HttpStatus.OK
        );

    }

}

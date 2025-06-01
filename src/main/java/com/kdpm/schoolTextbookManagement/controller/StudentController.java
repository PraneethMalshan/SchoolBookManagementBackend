package com.kdpm.schoolTextbookManagement.controller;

import com.kdpm.schoolTextbookManagement.dto.StudentDTO;
import com.kdpm.schoolTextbookManagement.dto.request.StudentUpdateDTO;
import com.kdpm.schoolTextbookManagement.service.BookService;
import com.kdpm.schoolTextbookManagement.service.StudentService;
import com.kdpm.schoolTextbookManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> saveStudent(@RequestBody StudentDTO studentDTO){
        String message = studentService.saveStudent(studentDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO){
        String message = studentService.updateStudent(studentUpdateDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-by-id", params = "id")
    public ResponseEntity<StandardResponse> getStudentId(@RequestParam(value = "id") int studentId){
        StudentDTO studentDTO = studentService.getStudentById(studentId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Found", studentDTO),
                HttpStatus.OK
        );
    }

}

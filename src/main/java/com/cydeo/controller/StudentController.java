package com.cydeo.controller;


import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.StudentDTO;
import com.cydeo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getStudents(){
        return ResponseEntity.ok(
                ResponseWrapper.builder()
                        .success(true)
                        .data(studentService.findAll())
                        .code(HttpStatus.OK.value())
                        .message("Students are successfully retrieved.")
                        .build()
        );
    }

     /*
           Endpoint: /api/v1/student
           HTTP Status Code: 200

           JSON Response Body:
           "success": true
           "message": "Students are successfully retrieved."
           "code":200
           "data":<students data>
     */

    @PostMapping
    public ResponseEntity<ResponseWrapper> createStudent(@RequestBody StudentDTO studentDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponseWrapper.builder()
                        .message("Student is successfully created.")
                        .data(studentService.createStudent(studentDTO))
                        .success(true)
                        .code(HttpStatus.CREATED.value())
                        .build()
                );
    }

    /*
          Endpoint: /api/v1/student
          HTTP Status Code: 201

          JSON Response Body:
          "success": true
          "message": "Student is successfully created."
          "code":201
          "data":<created student data>
    */

}

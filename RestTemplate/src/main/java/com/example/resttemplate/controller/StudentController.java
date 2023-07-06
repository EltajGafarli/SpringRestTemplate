package com.example.resttemplate.controller;

import com.example.resttemplate.client.StudentClient;
import com.example.resttemplate.dto.StudentDto;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentClient studentClient;

    @GetMapping(path = "")
    public ResponseEntity<JsonNode> students(){
        return studentClient.getAllStudents();
    }

    @GetMapping(path = "/maps")
    public ResponseEntity<JsonNode> getStudentMaps(){
        return studentClient.getDtoAsMaps();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable long id){
        return this.studentClient.getStudentById(id);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        return this.studentClient.saveStudent(studentDto);
    }

}

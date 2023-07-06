package com.example.tryfeingclient.controller;

import com.example.tryfeingclient.client.StudentClient;
import com.example.tryfeingclient.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentClient studentClient;

    @GetMapping(path = "/{id}")
    public StudentDto getStudentById(@PathVariable long id){
        return studentClient.getStudentById(id);
    }

    @GetMapping(path = "")
    public List<StudentDto> getAllStudents(){
        return studentClient.getStudents();
    }

    @PostMapping(path = "")
    public void saveStudent(@RequestBody StudentDto studentDto){
        this.studentClient.saveStudent(studentDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable long id){
        this.studentClient.deleteStudent(id);
    }


}

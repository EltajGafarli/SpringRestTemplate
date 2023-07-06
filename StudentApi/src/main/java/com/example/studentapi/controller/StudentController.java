package com.example.studentapi.controller;

import com.example.studentapi.dto.StudentDto;
import com.example.studentapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping(path = "")
    public List<StudentDto> findAll(){
        return this.studentService.getStudents();
    }


    @GetMapping(path = "/{id}")
    public StudentDto findById(@PathVariable long id){
        return this.studentService.getStudentById(id);
    }

    @PostMapping(path = "")
    public void save(@RequestBody StudentDto studentDto){
        this.studentService.save(studentDto);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id){
        this.studentService.deleteById(id);
    }

}

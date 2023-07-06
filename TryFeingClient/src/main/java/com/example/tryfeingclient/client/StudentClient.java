package com.example.tryfeingclient.client;

import com.example.tryfeingclient.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient(name = "student-client", url = "http://localhost:8082/students")
public interface StudentClient {

    @GetMapping(path = "/{id}")
    StudentDto getStudentById(@PathVariable long id);

    @GetMapping(path = "")
    List<StudentDto> getStudents();

    @PostMapping(path = "")
    void saveStudent(@RequestBody StudentDto studentDto);

    @DeleteMapping(path = "/{id}")
    void deleteStudent(@PathVariable long id);
}

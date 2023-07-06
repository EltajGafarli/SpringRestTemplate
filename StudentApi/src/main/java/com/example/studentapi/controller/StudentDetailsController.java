package com.example.studentapi.controller;

import com.example.studentapi.dto.StudentDetailsDto;
import com.example.studentapi.service.StudentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentDetailsController {
    public final StudentDetailsService studentDetailsService;

    @GetMapping(path = "/{id}/details")
    public StudentDetailsDto findById(@PathVariable long id){
        return this.studentDetailsService.getById(id);
    }

    @DeleteMapping(path = "/{id}/details")
    public void delete(@PathVariable long id){
        this.studentDetailsService.delete(id);
    }

    @PostMapping(path = "/{id}/details")
    public void addDetails(@PathVariable long id, @RequestBody StudentDetailsDto studentDetailsDto){
        this.studentDetailsService.save(id, studentDetailsDto);
    }
}

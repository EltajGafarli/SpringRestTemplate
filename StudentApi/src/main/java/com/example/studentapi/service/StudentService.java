package com.example.studentapi.service;

import com.example.studentapi.dto.StudentDto;
import com.example.studentapi.entity.Student;
import com.example.studentapi.mapper.StudentMapper;
import com.example.studentapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    public StudentDto getStudentById(long id){
        Student student = this.studentRepository.findById(id).get();

        return mapper.studentToStudentDto(student);
    }

    public List<StudentDto>  getStudents(){
        List<Student> all = this.studentRepository.findAll();
        return all.stream()
                .map(mapper::studentToStudentDto).toList();
    }

    @Transactional
    public void save(StudentDto dto){
        Student student = mapper.StudentDtoToStudent(dto);
        this.studentRepository.save(student);
    }

    @Transactional
    public void deleteById(long id){
        this.studentRepository.deleteById(id);
    }

}

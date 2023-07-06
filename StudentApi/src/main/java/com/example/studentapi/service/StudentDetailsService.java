package com.example.studentapi.service;

import com.example.studentapi.dto.StudentDetailsDto;
import com.example.studentapi.entity.Student;
import com.example.studentapi.entity.StudentDetails;
import com.example.studentapi.mapper.StudentDetailsMapper;
import com.example.studentapi.repository.StudentDetailsRepository;
import com.example.studentapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentDetailsService {
    private final StudentDetailsRepository studentDetailsRepository;
    private final StudentRepository studentRepository;

    private final StudentDetailsMapper mapper;

    public StudentDetailsDto getById(long id){
        Student student = studentRepository.findById(id).get();
        return mapper.detailsToDetailsDto(student.getStudentDetails());
    }

    @Transactional
    public void save(long id, StudentDetailsDto detailsDto){
        Student student = studentRepository.findById(id).get();
        StudentDetails studentDetails = mapper.detailsDtoToDetails(detailsDto);
        studentDetails.setStudent(student);
        student.setStudentDetails(studentDetails);

        this.studentDetailsRepository.save(studentDetails);
        this.studentRepository.save(student);
    }

    @Transactional
    public void delete(long id){
        StudentDetails studentDetails = this.studentDetailsRepository.findById(id).get();
        studentDetails.setStudent(null);
        this.studentDetailsRepository.delete(studentDetails);
    }

}

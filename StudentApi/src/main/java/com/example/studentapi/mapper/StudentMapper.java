package com.example.studentapi.mapper;

import com.example.studentapi.dto.StudentDto;
import com.example.studentapi.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)

public interface StudentMapper {

    Student StudentDtoToStudent(StudentDto studentDto);
    StudentDto studentToStudentDto(Student student);
}

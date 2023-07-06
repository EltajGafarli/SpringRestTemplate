package com.example.studentapi.mapper;

import com.example.studentapi.dto.StudentDetailsDto;
import com.example.studentapi.entity.StudentDetails;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface StudentDetailsMapper {
    StudentDetails detailsDtoToDetails(StudentDetailsDto details);
    StudentDetailsDto detailsToDetailsDto(StudentDetails details);
}

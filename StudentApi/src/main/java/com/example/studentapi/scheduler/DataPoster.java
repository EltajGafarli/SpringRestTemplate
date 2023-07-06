package com.example.studentapi.scheduler;

import com.example.studentapi.dto.StudentDetailsDto;
import com.example.studentapi.dto.StudentDto;
import com.example.studentapi.entity.StudentDetails;
import com.example.studentapi.service.StudentDetailsService;
import com.example.studentapi.service.StudentService;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataPoster {

    private Faker faker;
    private final StudentService studentService;
    private final StudentDetailsService studentDetailsService;

    private static long id = 1;
    private UUID uuid;

    @PostConstruct
    void setup(){
        faker = new Faker();
        uuid = UUID.randomUUID();
    }

//    @Scheduled(fixedDelay = 1000)
    public void addStudent(){
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        StudentDto studentDto = StudentDto.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
        studentService.save(studentDto);

        StudentDetailsDto studentDetailsDto = StudentDetailsDto.builder()
                .email(firstName + "@gmail.com")
                .passwordId(uuid.toString())
                .build();


        studentDetailsService.save(id ++, studentDetailsDto);

    }
}

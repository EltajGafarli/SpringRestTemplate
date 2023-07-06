package com.example.resttemplate.client;

import com.example.resttemplate.dto.StudentDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.net.httpserver.HttpsServer;
import lombok.RequiredArgsConstructor;
import org.hibernate.usertype.BaseUserTypeSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class StudentClient {

    @Autowired
    @Qualifier(value = "80821")
    private RestTemplateBuilder restTemplateBuilder;


    public ResponseEntity<StudentDto> listStudents(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("students", Map.class);


        return restTemplate.getForEntity("students/1", StudentDto.class);
    }

    public ResponseEntity<JsonNode> getDtoAsMaps(){
        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("students");
        uriComponentsBuilder.queryParam("name", "Eltaj");
        restTemplate.getForObject(uriComponentsBuilder.toUriString(), StudentDto.class, "1");

        return restTemplate.getForEntity(uriComponentsBuilder.toUriString(), JsonNode.class);
    }


    public ResponseEntity<JsonNode> getAllStudents(){
        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("students");
        JsonNode forObject = restTemplate.getForObject(uriComponentsBuilder.toUriString(), JsonNode.class);
        return new ResponseEntity<>(forObject, HttpStatus.OK);
    }


    public ResponseEntity<StudentDto> getStudentById(long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.exchange("", HttpMethod.GET, HttpEntity.EMPTY, Void.class);
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("students/{id}");
        String url = "students/{id}";
        return restTemplate.getForEntity(url, StudentDto.class, id);

    }

    public ResponseEntity<StudentDto> saveStudent(StudentDto studentDto){
        RestTemplate restTemplate = restTemplateBuilder.build();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("students");
        return restTemplate.postForEntity(uriComponentsBuilder.toUriString(), studentDto, StudentDto.class);
    }

}

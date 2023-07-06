package com.example.studentapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.threads.InlineExecutorService;
import org.springframework.context.annotation.EnableMBeanExport;

import java.time.LocalDate;

@Entity
@Table(name = "student_details")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, unique = true)
    private String email;

    @Column
    private String passwordId;

    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, mappedBy = "studentDetails")
    private Student student;
}

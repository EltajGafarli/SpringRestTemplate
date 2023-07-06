package com.example.studentapi.repository;

import com.example.studentapi.entity.Student;
import com.example.studentapi.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

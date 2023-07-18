package com.algosantosh.springdatajpaseries.repository;

import com.algosantosh.springdatajpaseries.entity.Course;
import com.algosantosh.springdatajpaseries.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher() {

        Course courseDSA = Course.builder()
                .title("Data Structures and Algorithms")
                .credit(15)
                .build();

        Course courseCC = Course.builder()
                .title("Cloud Computing")
                .credit(7)
                .build();

        Course courseML = Course.builder()
                .title("Machine Learning")
                .credit(10)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Santosh")
                .lastName("Shah")
                .courses(List.of(courseDSA, courseCC, courseML))
                .build();

        teacherRepository.save(teacher);
    }
}
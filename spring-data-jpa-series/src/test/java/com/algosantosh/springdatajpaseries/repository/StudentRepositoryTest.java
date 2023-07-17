package com.algosantosh.springdatajpaseries.repository;

import com.algosantosh.springdatajpaseries.entity.Guardian;
import com.algosantosh.springdatajpaseries.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

//    @Test
//    @Transactional
//    public void saveStudent() {
//        Student student = Student.builder()
//                .emailId("nareshshah@gmail.com")
//                .firstName("Naresh")
//                .lastName("Shah")
//                .guardianName("Binda Shah")
//                .guardianEmail("bindashah@gmail.com")
//                .guardianMobile("9814204005")
//                .build();
//        studentRepository.save(student);
//    }



    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Binda Shah")
                .email("bindashah@gmail.com")
                .mobile("9814204005")
                .build();

        Student student = Student.builder()
                .emailId("nareshshah@gmail.com")
                .firstName("Naresh")
                .lastName("Shah")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList: " + studentList);
    }

}
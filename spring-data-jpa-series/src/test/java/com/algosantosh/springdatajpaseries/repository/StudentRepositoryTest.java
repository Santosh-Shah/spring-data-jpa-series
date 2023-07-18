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
                .name("Motilal Yadav")
                .email("motilalyadav@gmail.com")
                .mobile("9845004005")
                .build();

        Student student = Student.builder()
                .emailId("maneeshyadav@gmail.com")
                .firstName("Maneesh")
                .lastName("Yadav")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList: " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Naresh");
        System.out.println("Student List: " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("na");
        System.out.println("Student List: " + studentList);
    }

//    @Test
//    public void printStudentByLastName() {
//        List<Student> studentList = studentRepository.findByLastNameNotNull("Shah");
//        System.out.println("Student List: " + studentList);
//    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("Binda Shah");
        System.out.println("Student List: " + studentList);
    }

    @Test
    public void printStudentByFistNameAndLastName() {
        List<Student> studentList = studentRepository.findByFirstNameAndLastName("Naresh", "Shah");
        System.out.println("Student List: " + studentList);
    }

    @Test
    public void printStudentByEmailId() {
        Student student = studentRepository.getStudentByEmailId("bijayshah@gmail.com");
        System.out.println("Student: " + student);
    }

    @Test
    public void printStudentFirstNameByEmailId() {
        String student = studentRepository.getStudentFirstNameByEmailId("maneeshyadav@gmail.com");
        System.out.println("Student Name: " + student);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("maneeshyadav@gmail.com");
        System.out.println("Student: " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParma() {
        Student student = studentRepository.getStudentByEmailAddressNative("bijayshah@gmail.com");
        System.out.println("Student: " + student);
    }

    @Test
    public void updateStudentNameByEmailAddressTest() {
            studentRepository.updateStudentNameByEmailId("Manif", "bijayshah@gmail.com");
    }


}
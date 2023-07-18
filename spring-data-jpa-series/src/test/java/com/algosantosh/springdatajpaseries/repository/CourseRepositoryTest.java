package com.algosantosh.springdatajpaseries.repository;

import com.algosantosh.springdatajpaseries.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourse() {
        Course course = Course.builder()
                .title("Java Programming")
                .credit(5)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void printAllCourse() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println("Courses List: " + courseList);
    }
}
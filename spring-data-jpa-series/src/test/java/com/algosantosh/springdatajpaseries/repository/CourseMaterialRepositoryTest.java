package com.algosantosh.springdatajpaseries.repository;

import com.algosantosh.springdatajpaseries.entity.Course;
import com.algosantosh.springdatajpaseries.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("Java Programming")
                .credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.geeksforgeeks.com")
                .course(course)
                .build();
        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial() {
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("Course Material List: " + courseMaterials);
    }

}
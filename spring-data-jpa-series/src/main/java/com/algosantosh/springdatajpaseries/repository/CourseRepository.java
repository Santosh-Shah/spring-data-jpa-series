package com.algosantosh.springdatajpaseries.repository;

import com.algosantosh.springdatajpaseries.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

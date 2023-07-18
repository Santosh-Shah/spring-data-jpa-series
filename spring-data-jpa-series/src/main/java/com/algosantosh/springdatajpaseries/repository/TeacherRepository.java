package com.algosantosh.springdatajpaseries.repository;

import com.algosantosh.springdatajpaseries.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}

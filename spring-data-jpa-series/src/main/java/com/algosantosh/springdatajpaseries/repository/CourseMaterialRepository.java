package com.algosantosh.springdatajpaseries.repository;

import com.algosantosh.springdatajpaseries.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}

package com.algosantosh.springdatajpaseries.repository;

import com.algosantosh.springdatajpaseries.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);
//    public List<Student> findByLastNameNotNull(String name);

    public List<Student> findByGuardianName(String name);

    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    // TODO:  this is JPQL query
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    Student getStudentByEmailId(String emailId);

    @Query("SELECT s.firstName FROM Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId(String emailId);

    // TODO: this is actual Native query
    @Query (
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailAddress);

    // TODO: this is using Query Named Params and this is best way to do
    @Query (
            value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailAddress);


    // using @Transactional and @Modifying Annotations
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name = ?1 WHERE email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);




}

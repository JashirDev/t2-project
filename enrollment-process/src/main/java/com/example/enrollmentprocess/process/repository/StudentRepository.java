package com.example.enrollmentprocess.process.repository;

import com.example.enrollmentprocess.process.model.jpamodel.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    Optional<Student> findByName(String name);
}

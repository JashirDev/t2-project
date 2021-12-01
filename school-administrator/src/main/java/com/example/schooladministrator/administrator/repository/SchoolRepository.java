package com.example.schooladministrator.administrator.repository;

import com.example.schooladministrator.administrator.model.jpamodel.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository  extends CrudRepository<School,Long> {

    Optional<School>findByName(String name);
}

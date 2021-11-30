package com.example.schooladministrator.administrator.repository;

import com.example.schooladministrator.administrator.model.SchoolData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository  extends CrudRepository<SchoolData,Long> {
}

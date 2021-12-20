package com.example.documentservice.repository;

import com.example.documentservice.model.jpa.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {

    Document findByDni(String dni);
}

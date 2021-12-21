package com.example.party.repository;

import com.example.party.model.jpamodel.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

   Optional<Person> findByDni(String dni);
}

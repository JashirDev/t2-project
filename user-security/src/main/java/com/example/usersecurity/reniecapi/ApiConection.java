package com.example.usersecurity.reniecapi;

import com.example.usersecurity.model.thirdparty.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiConection extends CrudRepository<Person,Long> {

    Optional<Person> findByDni(String dni);

}

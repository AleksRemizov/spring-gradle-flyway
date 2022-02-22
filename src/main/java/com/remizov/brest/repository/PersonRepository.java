package com.remizov.brest.repository;

import com.remizov.brest.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person , Integer> {
    Person findByName(String name);
}

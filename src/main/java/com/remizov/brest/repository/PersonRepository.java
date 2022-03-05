package com.remizov.brest.repository;

import com.remizov.brest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person , Integer> {
    Person findByName(String name);
}

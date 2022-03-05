package com.remizov.brest.repository;

import com.remizov.brest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person , Integer> {
    Optional<Person> findByName(String name);

}

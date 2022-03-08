package com.remizov.brest.repository;

import com.remizov.brest.entity.Person;
import com.remizov.brest.projection.PersonNameView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person , Integer>,PersonCustomRepository {

    Optional<Person> findByName(String name);

    @Query(value = "select * from person p where not p.name='null'", nativeQuery = true)
    List<PersonNameView> findAllWithName();
}

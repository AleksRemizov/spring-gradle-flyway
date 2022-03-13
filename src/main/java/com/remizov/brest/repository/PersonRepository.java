package com.remizov.brest.repository;

import com.remizov.brest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer>,PersonCustomRepository {

    @Query("SELECT p FROM Person p WHERE LOWER(p.name) = LOWER(:name)")
    Optional<Person> findByName(@Param("name")String name);

    @Query(value = "select * from person p where not p.name='null'", nativeQuery = true)
    List<Person> findAllWithName();

    Person getOne(Integer id);




}

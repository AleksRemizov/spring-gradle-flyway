package com.remizov.brest.repository;

import com.remizov.brest.entity.Person;

import java.util.List;

public interface PersonCustomRepository {

    List<Person> findByCustomQuery();
}

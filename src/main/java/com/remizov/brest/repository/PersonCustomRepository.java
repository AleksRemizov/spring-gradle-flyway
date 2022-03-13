package com.remizov.brest.repository;



import com.remizov.brest.entity.Person;

public interface PersonCustomRepository {

    Person getOne(Integer id);
}

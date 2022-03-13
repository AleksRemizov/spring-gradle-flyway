package com.remizov.brest.repository;

import com.remizov.brest.entity.Person;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class PersonCustomRepositoryImpl implements PersonCustomRepository{

    private final EntityManager em;

    @Override
    public Person getOne(Integer id) {
        return em.find(Person.class, id);
    }
}

package com.remizov.brest.repository;

import com.remizov.brest.entity.Person;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class PersonCustomRepositoryImpl implements PersonCustomRepository{

    private final EntityManager entityManager;

    @Override
    public List<Person> findByCustomQuery() {
        return Collections.emptyList();
    }
}

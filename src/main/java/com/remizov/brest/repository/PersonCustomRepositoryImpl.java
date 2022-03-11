package com.remizov.brest.repository;

import com.remizov.brest.entity.Person;
import com.remizov.brest.projection.PersonNameView;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class PersonCustomRepositoryImpl implements PersonCustomRepository{

    private final EntityManager entityManager;

    @Override
    public List<PersonNameView> findAllWithName() {
        return Collections.emptyList();
    }
}

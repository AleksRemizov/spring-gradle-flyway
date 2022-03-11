package com.remizov.brest.repository;


import com.remizov.brest.entity.Person;
import com.remizov.brest.projection.PersonNameView;

import java.util.List;

public interface PersonCustomRepository {

    List<PersonNameView> findAllWithName();
}

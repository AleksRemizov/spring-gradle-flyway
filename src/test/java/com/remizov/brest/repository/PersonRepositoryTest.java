package com.remizov.brest.repository;

import com.remizov.brest.IntegrationTestBase;
import com.remizov.brest.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryTest extends IntegrationTestBase {

    private static final Integer PERSON_ID = 1;

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
     void testGetById(){
       Optional<Person> person = personRepository.findById(PERSON_ID);
       assertTrue(person.isPresent());
       person.ifPresent(entity ->{
           assertEquals("Aleksandrov Sergey Ivanovich",entity.getName());
       });
    }

    @Test
    void testSave(){
        Person person = Person.builder()
                             .name("Aleks")
                             .password("20065")
                             .build();
        personRepository.save(person);
        assertNotNull(person.getId());
    }
}
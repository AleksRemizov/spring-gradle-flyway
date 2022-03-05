package com.remizov.brest.controller;

import com.remizov.brest.service.PersonService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PersonControllerTest {

    @Autowired
    PersonService personService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllPerson() {
    }

    @Test
    void registration() {
    }

    @Test
    void getOnePerson() {
    }

    @Test
    void updatePerson() {
    }

    @Test
    void deletePerson() {
    }
}
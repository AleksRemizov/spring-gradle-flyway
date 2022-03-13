package com.remizov.brest.service.impl;

import com.remizov.brest.entity.Person;
import com.remizov.brest.exception.NoFoundEntitiesException;
import com.remizov.brest.exception.NoUniqueEntityException;
import com.remizov.brest.exception.PersonNotFoundException;


import com.remizov.brest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class PersonServiceImpl {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPerson()   {
        List<Person> persons =  personRepository.findAllWithName();
        if(persons.isEmpty()){
            throw new NoFoundEntitiesException("No found any person!");
        }
            return persons;
    }

    public Person registration(Person person) throws NoUniqueEntityException {
        if(personRepository.findByName(person.getName()) != null){
            throw  new NoUniqueEntityException();
        }
        return personRepository.save(person);
    }

    public Person getOne(Integer id) throws  PersonNotFoundException {
           Person person = personRepository.findById(id)
                   .orElseThrow(()->new PersonNotFoundException("Person not found!"));
           return  person;
    }

    public Integer updatePerson(Person person){
        try{
            Person updated = (Person) personRepository.findByName(person.getName())
                    .orElseThrow(()->new PersonNotFoundException("Person not found!"));
            updated.setName(person.getName());
            updated.setPassword(person.getPassword());


            return personRepository.save(updated).getId();

        }catch (NoSuchElementException  |NullPointerException| EmptyResultDataAccessException e ){
            throw new PersonNotFoundException("Person not found!");
        }
    }


    public Integer delete(Integer id){
        try {
            personRepository.deleteById(id);
            return id;
        }catch (EmptyResultDataAccessException ex){
            throw new PersonNotFoundException("Person not found!");
        }
    }
}

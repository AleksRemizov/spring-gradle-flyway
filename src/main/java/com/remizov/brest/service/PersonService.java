package com.remizov.brest.service;

import com.remizov.brest.entity.Person;
import com.remizov.brest.exception.NoUniqueEntity;
import com.remizov.brest.exception.PersonNotFoundException;
import com.remizov.brest.model.PersonDto;
import com.remizov.brest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person registration(Person person) throws NoUniqueEntity {
        if(personRepository.findByName(person.getName()) != null){
            throw  new NoUniqueEntity("Person with this name already exist");
        }
        return personRepository.save(person);
    }

    public PersonDto getOne(Integer id) throws  PersonNotFoundException {
        Person person = personRepository.findById(id).get();
        if(person == null){
            throw new PersonNotFoundException("Person with this id not found!");
        }
        return PersonDto.toModel(person);
    }
    public Integer delete(Integer id){
        personRepository.deleteById(id);
        return id;
    }
}

package com.remizov.brest.service;

import com.remizov.brest.entity.Person;
import com.remizov.brest.exception.NoFoundEntitiesException;
import com.remizov.brest.exception.NoUniqueEntityException;
import com.remizov.brest.exception.PersonNotFoundException;
import com.remizov.brest.model.PersonDto;
import com.remizov.brest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<PersonDto> getAllPerson()   {
        List<Person> persons = (List<Person>) personRepository.findAll();
        if(persons.isEmpty()){
            throw new NoFoundEntitiesException("No found any person!");
        }
            return persons.stream()
                    .map(person -> PersonDto.toModel(person))
                    .collect(Collectors.toList());
    }

    public Person registration(Person person) throws NoUniqueEntityException {
        if(personRepository.findByName(person.getName()) != null){
            throw  new NoUniqueEntityException();
        }
        return personRepository.save(person);
    }

    public PersonDto getOne(Integer id) throws  PersonNotFoundException {

       try{
           Person person = personRepository.findById(id).get();
           return PersonDto.toModel(person);

       }catch (NoSuchElementException ex) {
           throw new PersonNotFoundException("Person not found!");
       }
    }

    public Integer updatePerson(Person person){
        try{
            Person updated = personRepository.findByName(person.getName());
            updated.setName(person.getName());
            updated.setPassword(person.getPassword());
            updated.setTasks(person.getTasks());

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

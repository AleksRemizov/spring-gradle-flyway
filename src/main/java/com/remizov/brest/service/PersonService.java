package com.remizov.brest.service;

import com.remizov.brest.entity.Person;
import com.remizov.brest.exception.NoUniqueEntityException;
import com.remizov.brest.exception.PersonNotFoundException;
import com.remizov.brest.model.PersonDto;
import com.remizov.brest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<PersonDto> getAllPerson()   {
        List<Person> persons = (List<Person>) personRepository.findAll();
            return persons.stream()
                    .map(person -> PersonDto.toModel(person))
                    .collect(Collectors.toList());
    }

    public Person registration(Person person) throws NoUniqueEntityException {
        if(personRepository.findByName(person.getName()) != null){
            throw  new NoUniqueEntityException("Person with this name already exist");
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

    public Integer updatePerson(Person person){
        Person updated = personRepository.findByName(person.getName());
        updated.setName(person.getName());
        updated.setPassword(person.getPassword());
        updated.setTasks(person.getTasks());

        return personRepository.save(updated).getId();
    }


    public Integer delete(Integer id){
        personRepository.deleteById(id);
        return id;
    }
}

package com.remizov.brest.controller;

import com.remizov.brest.entity.Person;
import com.remizov.brest.exception.NoUniqueEntityException;
import com.remizov.brest.exception.PersonNotFoundException;
import com.remizov.brest.model.PersonDto;
import com.remizov.brest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public final List<PersonDto> getAllPerson(){
            return personService.getAllPerson();
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody Person person){

        try{
            personService.registration(person);
             return ResponseEntity.ok().body("Client saved !");

        } catch (NoUniqueEntityException e) {
            return ResponseEntity.badRequest().body("Person with this id already exist!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOnePerson(@PathVariable Integer id){
        try{
             return ResponseEntity.ok(personService.getOne(id));

        } catch (NoSuchElementException e) {
            throw new PersonNotFoundException("No found person with this id");
        }
    }

    @PutMapping( consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Integer> updatePerson(@RequestBody Person person){
        int updatedPersonId = personService.updatePerson(person);
        return new ResponseEntity(updatedPersonId, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(personService.delete(id));

        } catch (PersonNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something wrong");
        }
    }
}


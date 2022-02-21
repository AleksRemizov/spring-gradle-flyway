package com.remizov.brest.controller;

import com.remizov.brest.model.Person;
import com.remizov.brest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public ResponseEntity registration(@RequestBody Person person){

        try{
            personRepository.save(person);
             return ResponseEntity.ok().body("Client saved !");

        }catch (Exception ex){
        return ResponseEntity.badRequest().body("Something wrong");
        }
    }

    @GetMapping
    public ResponseEntity getUsers(){
        try{
             return ResponseEntity.ok().body("Server available");

        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Something wrong");
        }
    }
}


package com.remizov.brest.controller;

import com.remizov.brest.entity.Person;
import com.remizov.brest.exception.NoUniqueEntity;
import com.remizov.brest.exception.PersonNotFoundException;
import com.remizov.brest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity registration(@RequestBody Person person){

        try{
            personService.registration(person);
             return ResponseEntity.ok().body("Client saved !");

        } catch (NoUniqueEntity e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (Exception e) {
           return ResponseEntity.badRequest().body("Something wrong");
        }
    }

    @GetMapping
    public ResponseEntity getOnePerson(@RequestParam Integer id){
        try{
             return ResponseEntity.ok(personService.getOne(id));

        } catch (PersonNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something wrong");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(personService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something wrong");
        }
    }

}


package com.remizov.brest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

//    @Autowired
//    PersonService personService;
//
//    @GetMapping
//    public final List<PersonDto> getAllPerson(){
//            return personService.getAllPerson();
//    }
//
//    @PostMapping
//    public ResponseEntity registration(@RequestBody Person person){
//
//        try{
//            personService.registration(person);
//             return ResponseEntity.ok().body("Client saved !");
//
//        } catch (NoUniqueEntityException e) {
//            return ResponseEntity.badRequest().body("Person with this id already exist!");
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity getOnePerson(@PathVariable Integer id){
//        try{
//             return ResponseEntity.ok(personService.getOne(id));
//
//        } catch (NoSuchElementException e) {
//            throw new PersonNotFoundException("No found person with this id");
//        }
//    }
//
//    @PutMapping( consumes = {"application/json"}, produces = {"application/json"})
//    public ResponseEntity<Integer> updatePerson(@RequestBody Person person){
//        int updatedPersonId = personService.updatePerson(person);
//        return new ResponseEntity(updatedPersonId, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity deletePerson(@PathVariable Integer id){
//        try{
//            return ResponseEntity.ok(personService.delete(id));
//
//        } catch (PersonNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Something wrong");
//        }
//    }
}


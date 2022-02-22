package com.remizov.brest.controller;

import com.remizov.brest.entity.Task;
import com.remizov.brest.exception.PersonNotFoundException;
import com.remizov.brest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity createTask(@RequestBody Task task,
                                     @RequestParam Integer personId){
        try{
            return ResponseEntity.ok(taskService.createTask(task,personId));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something wrong");
        }
    }

    @PutMapping
    public ResponseEntity completeTask(@RequestParam Integer id){
        try{
            return ResponseEntity.ok(taskService.complete(id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something wrong");
        }
    }
}

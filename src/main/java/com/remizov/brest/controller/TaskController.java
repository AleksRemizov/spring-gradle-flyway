package com.remizov.brest.controller;

import com.remizov.brest.entity.Person;
import com.remizov.brest.entity.Task;
import com.remizov.brest.exception.PersonNotFoundException;
import com.remizov.brest.model.PersonDto;
import com.remizov.brest.model.TaskDto;
import com.remizov.brest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
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

    @GetMapping
    public List<TaskDto> findAllTask(){
        return taskService.findAllTasks();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Integer id){
        TaskDto task = taskService.findTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);

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

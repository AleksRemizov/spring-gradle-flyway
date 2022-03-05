package com.remizov.brest.controller;

import com.remizov.brest.entity.Task;
import com.remizov.brest.exception.TaskNotFoundException;
import com.remizov.brest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

//    @Autowired
//    TaskService taskService;
//
//    @PostMapping
//    public ResponseEntity createTask(@RequestBody Task task,
//                                     @RequestParam Integer personId){
//            return ResponseEntity.ok(taskService.createTask(task,personId));
//    }
//
//    @GetMapping
//    public List<TaskDto> findAllTask(){
//        return taskService.findAllTasks();
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<TaskDto> getTaskById(@PathVariable Integer id){
//        try {
//             TaskDto task = taskService.findTaskById(id);
//              return new ResponseEntity<>(task, HttpStatus.OK);
//
//        } catch (TaskNotFoundException exc) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Track Not Found", exc);
//        }
//    }
//
//
//    @PutMapping( consumes = {"application/json"}, produces = {"application/json"})
//    public ResponseEntity<Integer> updateTask(@RequestParam Integer id,
//                                               @RequestBody Task task){
//        int updatedTaskId = taskService.update(id,task);
//        return new ResponseEntity(updatedTaskId, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteTask(@PathVariable Integer id){
//        int deletedId = taskService.deleteTask(id);
//        return new ResponseEntity(deletedId,HttpStatus.OK);
//    }
}

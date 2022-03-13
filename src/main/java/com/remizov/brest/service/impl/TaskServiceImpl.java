package com.remizov.brest.service.impl;

import com.remizov.brest.entity.Person;
import com.remizov.brest.entity.Task;
import com.remizov.brest.exception.NoFoundEntitiesException;
import com.remizov.brest.exception.PersonNotFoundException;
import com.remizov.brest.exception.TaskNotFoundException;

import com.remizov.brest.projection.TaskTitleView;
import com.remizov.brest.repository.PersonRepository;
import com.remizov.brest.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskServiceImpl {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    PersonRepository personRepository;

    public List<Task> findAllTasks(){
        List<Task> tasks = taskRepository.findAll();
        if(tasks.isEmpty()){
            throw new NoFoundEntitiesException("No found any task!");
        }
        return  tasks;
    }

    public Task findTaskById(Integer id) {
        try{
            Task task = taskRepository.findById(id).get();
            return  task;
        }catch (NoSuchElementException e) {
            throw new TaskNotFoundException("Task with this id not found!");
        }
    }

    public Task createTask(Task task, Integer personId) {
        try {
            Person person = personRepository.findById(personId).get();
            task.setPerson(person);
            return  taskRepository.save(task);

        } catch (NoSuchElementException | EmptyResultDataAccessException e) {
            throw new PersonNotFoundException("Owner this task not found ");
        }
    }

    public int update(Integer id,Task task) {
        try {
            Task updatedTask = taskRepository.findById(id).get();
            updatedTask.setCompleted(task.getCompleted());
            updatedTask.setTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setPerson(task.getPerson());

            return updatedTask.getId();

        }catch (NoSuchElementException  | EmptyResultDataAccessException e ){
            throw new TaskNotFoundException("Task not found!");
        }
    }

    public Integer deleteTask(Integer id){
        try{
            taskRepository.deleteById(id);
            return id;
        }catch (NoSuchElementException | EmptyResultDataAccessException e){
            throw new TaskNotFoundException("Task no found!");
        }
    }
}

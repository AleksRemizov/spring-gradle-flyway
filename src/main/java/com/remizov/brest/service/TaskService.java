package com.remizov.brest.service;

import com.remizov.brest.entity.Person;
import com.remizov.brest.entity.Task;
import com.remizov.brest.model.TaskDto;
import com.remizov.brest.repository.PersonRepository;
import com.remizov.brest.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    PersonRepository personRepository;



    public TaskDto createTask(Task task, Integer userId){
        Person person = personRepository.findById(userId).get();
        task.setPerson(person);
        return TaskDto.toModel(taskRepository.save(task));

    }

    public TaskDto complete(Integer id){
        Task task = taskRepository.findById(id).get();
        task.setCompleted(!task.getCompleted());
        return TaskDto.toModel(taskRepository.save(task));
    }
}

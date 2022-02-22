package com.remizov.brest.model;

import com.remizov.brest.entity.Person;
import com.remizov.brest.entity.Task;

import java.util.List;
import java.util.stream.Collectors;

public class PersonDto {
    private Integer id;
    private String name;
    private List<TaskDto> tasks;

    public PersonDto() {
    }

    public static PersonDto toModel(Person person){
        PersonDto model = new PersonDto();
        model.setId(person.getId());
        model.setName(person.getName());
        model.setTasks(person.getTasks().stream().map(TaskDto::toModel).collect(Collectors.toList()));
        return model;
    }

    public Integer getId() {
        return id;
    }

    public PersonDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public PersonDto setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
        return this;
    }
}

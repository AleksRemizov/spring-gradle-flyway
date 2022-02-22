package com.remizov.brest.model;

import com.remizov.brest.entity.Person;

public class PersonDto {
    private Integer id;
    private String name;

    public PersonDto() {
    }

    public static PersonDto toModel(Person person){
        PersonDto model = new PersonDto();
        model.setId(person.getId());
        model.setName(person.getName());
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
}

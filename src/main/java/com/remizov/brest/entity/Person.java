package com.remizov.brest.entity;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "person")
    private List<Task> tasks;

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public Person setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Person setTasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }
}

package com.remizov.brest.entity;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Boolean completed;
    private String description;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public Task setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Task setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Task setPerson(Person person) {
        this.person = person;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }
}

package com.remizov.brest.model;

import com.remizov.brest.entity.Task;

public class TaskDto {
    private Integer id;
    private String title;
    private Boolean completed;


    public TaskDto() {
    }

    public static TaskDto toModel(Task task){
        TaskDto model = new TaskDto();
        model.setId(task.getId());
        model.setTitle(task.getTitle());
        model.setCompleted(task.getCompleted());
        return model;
    }

    public Integer getId() {
        return id;
    }

    public TaskDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TaskDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public TaskDto setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }
}

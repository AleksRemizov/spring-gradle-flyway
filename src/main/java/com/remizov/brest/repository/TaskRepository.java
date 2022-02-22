package com.remizov.brest.repository;

import com.remizov.brest.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Integer> {
}

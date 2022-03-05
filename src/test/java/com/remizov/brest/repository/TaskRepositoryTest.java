package com.remizov.brest.repository;

import com.remizov.brest.IntegrationTestBase;
import com.remizov.brest.entity.Task;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskRepositoryTest extends IntegrationTestBase {

    private static final Integer SOME_ID = 1;

    @Autowired
    TaskRepository taskRepository;

    @Test
    void testFindById(){
    Optional<Task> task = taskRepository.findById(SOME_ID);
    assertTrue(task.isPresent());
    }

    @Test
    void testFindByTitle(){
        Optional<Task> task = taskRepository.findByTitleContaining("some title2");
        assertTrue(task.isPresent());
    }

    @Test
    void testFindByTitleAndCompleted(){
        List<Task> tasks = taskRepository.findByTitleAndCompleted("some ",false);
        assertThat(tasks, IsCollectionWithSize.hasSize(2));

    }

}
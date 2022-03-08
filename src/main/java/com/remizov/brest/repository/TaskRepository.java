package com.remizov.brest.repository;

import com.remizov.brest.entity.Task;
import com.remizov.brest.projection.TaskTitleView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Integer> {

    Optional<Task> findByTitleContaining(String title);

    @Query("select t from Task t where t.title = :title and t.completed = :completed")
    List<Task> findByTitleAndCompleted(@Param("title") String title, @Param("completed") Boolean completed);

    @Query("select t from Task t where t.completed = :completed")
    List<TaskTitleView> findAllByCompletedStatus(@Param("completed")Boolean completed);

}

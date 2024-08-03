package com.example.practisewithoutsequrity.repository;

import com.example.practisewithoutsequrity.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

    Optional<Task> findById(Integer titleId);

    @Query("SELECT t FROM Task t WHERE t.completed = true")
    List<Task> findCompletedTasks();
}

package com.example.practisewithoutsequrity.repository;

import com.example.practisewithoutsequrity.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

    Optional<Task> findById(Integer titleId);

}

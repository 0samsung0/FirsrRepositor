package com.example.practisewithoutsequrity.service;


import com.example.practisewithoutsequrity.entity.Task;
import com.example.practisewithoutsequrity.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public void saveTask(Task task) {taskRepo.save(task);}

    public List<Task> findByAll() {
        return taskRepo.findAll();
    }

}

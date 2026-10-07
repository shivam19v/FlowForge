package com.shivam.taskmanager.service;

import com.shivam.taskmanager.task.*;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public TaskResponse createTask(CreateTaskRequest request) {

        Task task = new Task(
                request.getTitle(),
                request.getDescription(),
                request.getStatus()
        );

        Task savedTask = taskRepo.save(task);

        return new TaskResponse(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.getStatus()
        );
    }

    public TaskResponse getTask(Long id) {

        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
        );
    }
}
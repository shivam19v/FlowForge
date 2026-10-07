package com.shivam.taskmanager.common;

import com.shivam.taskmanager.task.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleTaskNotFound(TaskNotFoundException exception) {
        return Map.of(
                "status", HttpStatus.NOT_FOUND.value(),
                "message", exception.getMessage()
        );
    }
}
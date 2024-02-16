package com.todolist.controllers;

import com.todolist.entities.Task;
import com.todolist.services.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "newTask")
    public ResponseEntity<Task> newTask(@Valid @RequestBody Task newTask) {
        if (newTask != null) {
            Task task = taskService.newTask(newTask);
        }
        throw new NullPointerException();
    }

    @GetMapping(value = "getTaskById/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            return ResponseEntity.ok().body(task);
        }
        throw new NullPointerException();
    }

    @GetMapping(value = "getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> allTasks = taskService.getAllTasks();
        if (!(allTasks.isEmpty())) {
            return ResponseEntity.ok().body(allTasks);
        }
        throw new NullPointerException();
    }

    @PutMapping(value = "updateTask/{id}")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody Task updatedTask, @PathVariable Integer id) {
        Task taskUpdated = taskService.updateTaskById(id, updatedTask);
        if (taskUpdated != null) {
            return ResponseEntity.ok().body(updatedTask);
        }
        throw new NullPointerException();
    }

    @DeleteMapping(value = "deleteTask/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.notFound().build();
    }
}
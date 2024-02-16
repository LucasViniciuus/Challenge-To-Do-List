package com.todolist.services;

import com.todolist.entities.Task;
import com.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task newTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Integer id) {
        Task task = taskRepository.getById(id);
        return task;
    }

    public Task updateTaskById(Integer id, Task taskUpdated) {
        Task oldTask = this.getTaskById(id);
        if (oldTask != null && oldTask.getId() == id) {
            oldTask.setTaskName(taskUpdated.getTaskName());
            oldTask.setDateTask(taskUpdated.getDateTask());
            oldTask.setAccomplishedTask(taskUpdated.getAccomplishedTask());
            oldTask.setDescription(taskUpdated.getDescription());
            taskRepository.save(taskUpdated);
            return taskUpdated;
        }
        return null;
    }

    public void deleteTaskById(Integer id) {
        Task task = this.getTaskById(id);
        if (task != null) {
            taskRepository.deleteById(id);
        }
        throw new NullPointerException();
    }
}

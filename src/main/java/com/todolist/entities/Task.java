package com.todolist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    private String taskName;
    private String description;
    private int priority;
    private Date dateTask;
    private boolean accomplishedTask;

    public Task(String taskName, String description, int priority, Date dateTask, boolean accomplishedTask) {
        this.taskName = taskName;
        this.description = description;
        this.priority = priority;
        this.dateTask = dateTask;
        this.accomplishedTask = accomplishedTask;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDateTask(Date dateTask){
        this.dateTask = dateTask;
    }

    public Date getDateTask(){
        return dateTask;
    }

    public boolean isAccomplishedTask() {
        return accomplishedTask;
    }

    public void setAccomplishedTask(boolean accomplishedTask) {
        this.accomplishedTask = accomplishedTask;
    }
}

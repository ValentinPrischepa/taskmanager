package service;

import entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    void addTask(Task task);
}

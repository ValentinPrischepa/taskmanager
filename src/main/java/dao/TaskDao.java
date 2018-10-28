package dao;

import entity.Task;

import java.util.List;

public interface TaskDao {

    List<Task> getAllTasks();

    void addTask(Task task);
}

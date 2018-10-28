package service;

import dao.TaskDao;
import dao.jdbc.TaskDaoJDBC;
import entity.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Override
    public List<Task> getAll() {
        TaskDao taskDao = new TaskDaoJDBC();
        return taskDao.getAllTasks();
    }

    @Override
    public void addTask(Task task) {
        TaskDao taskDao = new TaskDaoJDBC();
        taskDao.addTask(task);
    }
}

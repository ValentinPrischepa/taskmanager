package dao.jdbc;


import dao.TaskDao;
import entity.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoJDBC implements TaskDao {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/task_manager";
    private static final String USER = "val";
    private static final String PASSWORD = "password";
    private static final String TASK_TABLE = "tasks";
    private static final String TASK_ID_COLUMN = "id";
    private static final String TASK_NAME_COLUMN = "task_name";

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<Task> getAllTasks() {

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT " + TASK_ID_COLUMN + "," + TASK_NAME_COLUMN + " FROM " + TASK_TABLE))
        {
            TaskRowMapper taskRowMapper = new TaskRowMapper();
            List<Task> tasks = new ArrayList<>();
            while (rs.next()) {
                tasks.add(taskRowMapper.getTask(rs));
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void addTask(Task task){
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();) {

            statement.executeUpdate("INSERT INTO " + TASK_TABLE + " (" +
                    TASK_NAME_COLUMN + ") VALUES (\'" + task.getName() + "\')");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package dao.jdbc;

import entity.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper {
    public Task getTask(ResultSet rs) throws SQLException {
        Task task = new Task(rs.getInt("id"),rs.getString("task_name"));
        return task;
    }
}

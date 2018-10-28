package dao.jdbc;

import entity.Task;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TaskRowMapperTest {
    @Test
    public void testGetTask() throws SQLException {
        TaskRowMapper taskRowMapper = new TaskRowMapper();
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("task_name")).thenReturn("Task Name 1");

        Task actualTask = taskRowMapper.getTask(rs);

        assertEquals(1,actualTask.getId());
        assertEquals("Task Name 1",actualTask.getName());
    }
}

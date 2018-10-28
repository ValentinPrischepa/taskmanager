package dao.jdbc;

import entity.Task;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class TaskDaoJDBCITest {
    @Test
    public void getAll(){
        TaskDaoJDBC taskDaoJDBC = new TaskDaoJDBC();

        List<Task> tasks = taskDaoJDBC.getAllTasks();

        for (Task task : tasks) {
            assertNotEquals(0,task.getId());
            assertNotNull(task.getName());
            System.out.println(task);
        }
    }
}

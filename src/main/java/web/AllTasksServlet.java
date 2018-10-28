package web;


import entity.Task;
import service.TaskService;
import web.templater.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AllTasksServlet extends HttpServlet {
    TaskService taskService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Task> tasks = taskService.getAll();
        HashMap<String, Object> params = new HashMap<>();
        params.put("tasks", tasks);

        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("/getalltasks.html",params);

        resp.getWriter().write(page);
    }

    public void setTaskService(TaskService taskService){
        this.taskService = taskService;
    }
}

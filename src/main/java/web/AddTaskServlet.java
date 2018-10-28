package web;

import entity.Task;
import service.TaskService;
import service.TaskServiceImpl;
import web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskName = req.getParameter("taskName");
        Task task = new Task(taskName);
        TaskService taskService = new TaskServiceImpl();
        taskService.addTask(task);
        resp.sendRedirect("addtask");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        HashMap<String, Object> params = new HashMap<>();
        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("addtask.html",params);

        resp.getWriter().write(page);
    }
}

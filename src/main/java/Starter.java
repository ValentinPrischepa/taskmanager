import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import service.TaskService;
import service.TaskServiceImpl;
import web.AddTaskServlet;
import web.AllTasksServlet;
import web.AssetsServlet;

public class Starter {

    public static void main(String[] args) throws Exception {

        TaskService taskService = new TaskServiceImpl();

        AllTasksServlet allTasksServlet = new AllTasksServlet();
        AddTaskServlet addTaskServlet = new AddTaskServlet();
        allTasksServlet.setTaskService(taskService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allTasksServlet), "/getalltasks");
        context.addServlet(new ServletHolder(addTaskServlet), "/addtask");
        context.addServlet(new ServletHolder(new AssetsServlet()),"/*");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
    }
}

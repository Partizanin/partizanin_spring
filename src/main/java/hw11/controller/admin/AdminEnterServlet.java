package hw11.controller.admin;

import hw11.service.admin.AdminService;
import hw11.service.client.ClientService;
import hw11.service.operator.OperatorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin_Spring.
 * User: Partizanin.
 * Date: 05.03.2015.
 * Time:  11:14.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
@WebServlet(name = "/AdminEnter")
public class AdminEnterServlet extends HttpServlet {

    private WebApplicationContext context;

    private AdminService adminService;
    private ClientService clientService;
    private OperatorService operatorService;


    @Override
    public void init() throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @RequestMapping(value = { "/", "/admin**" }, method = {RequestMethod.GET,RequestMethod.HEAD})
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("button").equals("Show Administrators List")) {
            adminService = (AdminService) context.getBean("adminServiceImpl");
            request.setAttribute("adminList", adminService.findAll());

            request.getRequestDispatcher("/hw11/jsp/admins/functions/adminsList.jsp").forward(request, response);

        } else if (request.getParameter("button").equals("Show Clients List")) {
            clientService = (ClientService) context.getBean("clientServiceImpl");
            request.setAttribute("clientList", clientService.findAll());

            request.getRequestDispatcher("/hw11/jsp/admins/functions/clientsList.jsp").forward(request, response);

        } else if (request.getParameter("button").equals("Show Operators List")) {
            operatorService = (OperatorService) context.getBean("operatorServiceImpl");
            request.setAttribute("operatorList", operatorService.findAll());

            request.getRequestDispatcher("/hw11/jsp/admins/functions/operatorsList.jsp").forward(request, response);
        }
    }
}

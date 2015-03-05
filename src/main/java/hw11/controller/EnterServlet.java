package hw11.controller;


import hw11.service.admin.AdminService;
import hw11.service.client.ClientService;
import hw11.service.operator.OperatorService;
import org.springframework.stereotype.Controller;
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
 * Project name: partizanin_spring
 * User: Partizanin
 * Date: 22.07.2014
 * Time: 15:12
 * To change this template use File|Setting|File Templates.
 */

@Controller
@WebServlet("/Enter")
public class EnterServlet extends HttpServlet {

    private WebApplicationContext context;

    private AdminService adminService;
    private ClientService clientService;
    private OperatorService operatorService;


    @Override
    public void init() throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
    @RequestMapping(value = { "/", "/welcome**" }, method = {RequestMethod.GET,RequestMethod.HEAD})
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (request.getParameter("client") != null) {

            request.getRequestDispatcher("/hw11/jsp/clients/LoginClient.jsp").forward(request, response);

        } else if (request.getParameter("operator") != null) {

            request.getRequestDispatcher("/hw11/jsp/operators/LoginOperator.jsp").forward(request, response);

        } else if (request.getParameter("administrator") != null) {

            request.getRequestDispatcher("/hw11/jsp/admins/LoginAdministrator.jsp").forward(request, response);

        }

    }
}

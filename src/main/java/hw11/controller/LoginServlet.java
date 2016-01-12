package hw11.controller;

import hw11.model.domain.Administrator;
import hw11.model.domain.Client;
import hw11.model.domain.Operator;
import hw11.service.admin.AdminService;
import hw11.service.client.ClientService;
import hw11.service.operator.OperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: partizanin_spring
 * User: Partizanin
 * Date: 22.07.2014
 * Time: 11:14
 * To change this template use File|Setting|File Templates.
 */
@Controller
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private WebApplicationContext context;

    private AdminService adminService;
    private ClientService clientService;
    private OperatorService operatorService;


    private List<Administrator> adminList = new ArrayList<>();
    private List<Client> clientList = new ArrayList<>();
    private List<Operator> operators = new ArrayList<>();


    @Override
    public void init() throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("registrationClient") != null) {

            request.getRequestDispatcher("/hw11/jsp/clients/RegistrationClient.jsp").forward(request, response);

        } else if (request.getParameter("registrationOperator") != null) {

            request.getRequestDispatcher("/hw11/jsp/operators/RegistrationOperator.jsp").forward(request, response);

        } else if (request.getParameter("registrationAdmin") != null) {

            request.getRequestDispatcher("/hw11/jsp/admins/RegistrationAdministrator.jsp").forward(request, response);

        }

        boolean loginBoolean = false;
        if (request.getParameter("submitAdmin") != null) {

            String login = request.getParameter("loginAdmin");
            String password = request.getParameter("passwordAdmin");
            log("Input login: " + login);
            log("Input pass: " + password);

            if (login != null && !login.equals("") &&
                    password != null && !password.equals("")) {
                adminService = (AdminService) context.getBean("adminServiceImpl");
                adminList = adminService.findAll();

                for (Administrator anAdminList : adminList) {
                    if (login.equals(anAdminList.getLogin()) && password.equals(anAdminList.getPassword())) {
                        loginBoolean = true;
                        request.getRequestDispatcher("/hw11/jsp/admins/enterAdmin.jsp").forward(request, response);
                    }
                }

                if (!loginBoolean) {

                    request.setAttribute("message", "Please input correct password and login!!");
                    request.getRequestDispatcher("/hw11/jsp/admins/LoginAdministrator.jsp").forward(request, response);

                }

            } else {
                request.setAttribute("message", "Please fill in all fields!!");
                request.getRequestDispatcher("/hw11/jsp/admins/LoginAdministrator.jsp").forward(request, response);
            }
        } else if (request.getParameter("submitClient") != null) {
            String name = request.getParameter("firstname");
            String surname = request.getParameter("surname");

            if (name != null && !name.equals("") && surname != null && !surname.equals("")) {
                clientService = (ClientService) context.getBean("clientServiceImpl");
                clientList = clientService.findAll();

                for (Client aClientList : clientList) {

                    if (aClientList.getName().equals(name) && aClientList.getSurname().equals(surname)) {
                        loginBoolean = true;
                        request.getRequestDispatcher("/hw11/jsp/clients/jsp/Yandexmap.html").forward(request, response);
                    } else if (aClientList.getName().equals(name) && !aClientList.getSurname().equals(surname)) {
                        request.setAttribute("message", "Please input correct surname!!");
                        request.getRequestDispatcher("/hw11/jsp/clients/LoginClient.jsp").forward(request, response);
                    } else if (!aClientList.getName().equals(name) && aClientList.getSurname().equals(surname)) {
                        request.setAttribute("message", "Please input correct name!!");
                        request.getRequestDispatcher("/hw11/jsp/clients/LoginClient.jsp").forward(request, response);
                    }
                }

                if (!loginBoolean) {

                    request.setAttribute("message", "Please input correct name and surname!!");
                    request.getRequestDispatcher("/hw11/jsp/clients/LoginClient.jsp").forward(request, response);

                }

            } else {
                request.setAttribute("message", "Please fill in all fields!!");
                request.getRequestDispatcher("/hw11/jsp/clients/LoginClient.jsp").forward(request, response);
            }

        } else if (request.getParameter("submitOperator") != null) {

            String login = request.getParameter("login");
            String password = request.getParameter("password");

            if (login != null && !login.equals("")
                    && password != null && !password.equals("")) {
                operatorService = (OperatorService) context.getBean("operatorServiceImpl");
                operators = operatorService.findAll();

                for (Operator operator : operators) {

                    if (login.equals(operator.getLogin()) && password.equals(operator.getPassword())) {
                        loginBoolean = true;
                        request.getRequestDispatcher("/hw11/jsp/loginSuccessful.jsp").forward(request, response);
                    }
                }

                if (!loginBoolean) {

                    request.setAttribute("message", "Please input correct password and login!!");
                    request.getRequestDispatcher("/hw11/jsp/operators/LoginOperator.jsp").forward(request, response);
                }

            } else {

                request.setAttribute("message", "Please fill in all fields!!");
                request.getRequestDispatcher("/hw11/jsp/operators/LoginOperator.jsp").forward(request, response);
            }
        }

    }
}

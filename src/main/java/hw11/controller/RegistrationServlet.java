package hw11.controller;

import hw11.model.domain.Administrator;
import hw11.model.domain.Client;
import hw11.model.domain.Operator;
import hw11.service.Utils;
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
import java.util.List;
import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 22.07.2014
 * Time: 10:56
 * To change this template use File|Setting|File Templates.
 */
@Controller
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {

    private WebApplicationContext context;

    private AdminService adminService;
    private OperatorService operatorService;
    private ClientService clientService;
    private Utils.Operator operatorUtils;
    private Utils.Client clientUtils;
    private Utils.Admin adminUtils;

    private List<Client> clients;
    private List<Operator> operators;
    private List<Administrator> administrators;

    /*Client: String name, String serName, String phoneNumber, String address, double summa, String lastDate
        Operator: String login, String password, String identifyNumber
        Admin: String login, String password, String loginAnotherAdmin*/
    @Override
    public void init()
            throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        adminService = (AdminService) context.getBean("adminServiceImpl");
        operatorService = (OperatorService) context.getBean("operatorServiceImpl");
        clientService = (ClientService) context.getBean("clientServiceImpl");

        if (request.getParameter("backClient") != null) {

            request.getRequestDispatcher("hw11/jsp/clients/LoginClient.jsp").forward(request, response);

        } else if (request.getParameter("backAdmin") != null) {

            request.getRequestDispatcher("/hw11/jsp/admins/LoginAdministrator.jsp").forward(request, response);

        } else if (request.getParameter("backOperator") != null) {

            request.getRequestDispatcher("/hw11/jsp/operators/LoginOperator.jsp").forward(request, response);

        }


        if (request.getParameter("regClient") != null) {

            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String phoneNumber = request.getParameter("phomeNumber");
            String address = request.getParameter("address");
            String price = request.getParameter("price");
            String dateOfLastOrder = request.getParameter("dateOfLastOrder");
            System.out.println(dateOfLastOrder);

            String result = registrationClient(name, surname, phoneNumber, address, price, dateOfLastOrder);

            if (result.equals("successful")) {

                clientService.create(new Client(name, surname, phoneNumber, address, Double.parseDouble(price), dateOfLastOrder));
                request.setAttribute("message", "Successful registration");
                request.getRequestDispatcher("/hw11/jsp/clients/LoginClient.jsp").forward(request, response);

            } else {
                request.setAttribute("message", result);
                request.getRequestDispatcher("/hw11/jsp/clients/RegistrationClient.jsp").forward(request, response);
            }

        } else if (request.getParameter("regAdmin") != null) {

            String login = request.getParameter("login");
            String pass = request.getParameter("password");
            String pass2 = request.getParameter("confirm password");
            String anotherLogin = request.getParameter("another login");

            String result = registrationAdmin(login, pass, pass2, anotherLogin);

            if (result.equals("successful")) {

                adminService.create(new Administrator(login, pass, anotherLogin));
                request.setAttribute("message", "Successful registration");
                request.getRequestDispatcher("/hw11/jsp/admins/LoginAdministrator.jsp").forward(request, response);
            } else {
                request.setAttribute("message", result);
                request.getRequestDispatcher("/hw11/jsp/admins/RegistrationAdministrator.jsp").forward(request, response);
            }


        } else if (request.getParameter("regOperator") != null) {

            String login = request.getParameter("login");
            String id = request.getParameter("identification number");
            String pass = request.getParameter("password");
            String pass2 = request.getParameter("password2");
            String anotherLogin = request.getParameter("another login");

            String result = registrationOperator(login, id, pass, pass2, anotherLogin);

            if (result.equals("successful")) {

                Operator operator = new Operator(login, pass, Integer.parseInt(id), anotherLogin);

                operatorService.create(operator);
                /*operatorService.create(new Operator(login,pass,Integer.parseInt(id),anotherLogin));*/
                request.setAttribute("message", "Successful registration");
                request.getRequestDispatcher("/hw11/jsp/operators/LoginOperator.jsp").forward(request, response);

            } else {
                request.setAttribute("message", result);
                request.getRequestDispatcher("/hw11/jsp/operators/RegistrationOperator.jsp").forward(request, response);
            }

        }

    }

    private String registrationOperator(String login, String id, String pass, String pass2, String anotherLogin) {

        if (login == null || login.equals("")) {
            return "Pleas input login";
        } else if (id == null || id.equals("")) {
            return "Pleas input identification number";
        } else if (pass == null || pass.equals("")) {
            return "Pleas input password";
        } else if (!operatorUtils.idCheck(id).equals("true")) {
            return "Bad number identification number -->>> " + operatorUtils.idCheck(id);
        } else if (!operatorUtils.passwordCheck(pass).equals("true")) {
            return "Bad password number -->>> " + operatorUtils.passwordCheck(pass);
        } else if (!operatorUtils.loginCheck(login).equals("true")) {

            return operatorUtils.loginCheck(login);

        } else {


            operators = operatorService.findAll();

            boolean login2 = false;

            try {

                Integer.parseInt(id);
            } catch (NumberFormatException e) {

                return "Input correct Identification number\n" +
                        "Its must have only numbers";
            }

            //Якщо не знайшло то повертаємо повідомлення
            for (Operator operator : operators) {

                if (operator.getLogin().equals(anotherLogin)) {

                    login2 = true;
                }
            }

            for (Operator operator : operators) {

                if (operator.getIdentifyNumber() == Integer.parseInt(id)) {

                    return "This Identification number already used!";
                }
            }


            if (!pass.equals(pass2)) {
                return "The passwords do not match!";
            }

            for (Operator operator : operators) {

                if (operator.getLogin().equals(login)) {

                    return "This login already used!";

                }
            }

            if (!login2) {
                return "Another administrator login does not exist!";
            }

        }

        return "successful";
    }

    private String registrationAdmin(String login, String pass, String pass2, String anotherLogin) {

        if (login == null || login.equals("")) {
            return "Pleas input login";

        } else if (pass == null || pass.equals("")) {
            return "Pleas input password";
        } else if (pass2 == null || pass2.equals("")) {
            return "Pleas confirm password";
        } else if (anotherLogin == null || anotherLogin.equals("")) {
            return "Pleas input another login";
        } else if (!adminUtils.loginCheck(login).equals("true")) {
            return "Bad login word " + adminUtils.loginCheck(login);
        } else if (!adminUtils.passwordCheck(pass).equals("true")) {
            return "Bad password word " + adminUtils.passwordCheck(pass);
        } else {


            administrators = adminService.findAll();

            boolean login2 = false;

            for (Administrator admin : administrators) {

                if (admin.getLogin().equals(anotherLogin)) {

                    login2 = true;
                }
            }

            if (!pass.equals(pass2)) {

                return "The passwords do not match!";
            }

            for (Administrator admin : administrators) {

                if (admin.getLogin().equals(login)) {

                    return "This login already used!";
                }
            }

            if (!login2) {
                return "Another operator login does not exist!";
            }

        }
        return "successful";

    }

    private String registrationClient(String name, String surname, String phoneNumber, String address, String price, String date) {

        if (name == null || name.equals("")) {

            return "Pleas input Name";
        } else if (surname == null || surname.equals("")) {

            return "Pleas input Surname";

        } else if (phoneNumber == null || phoneNumber.equals("")) {
            return "Pleas input phone number";

        } else if (address == null || address.equals("")) {
            return "Pleas input address";
        } else if (price == null || price.equals("")) {
            return "Pleas input price";
        } else if (date == null || date.equals("")) {
            return "Pleas input date";
        } else if (!clientUtils.nameSurnameCheck(name).equals("true")) {

            return "Bad name word " + clientUtils.nameSurnameCheck(name).replace("false", "");

        } else if (!clientUtils.nameSurnameCheck(surname).equals("true")) {

            return "Bad surname word " + clientUtils.nameSurnameCheck(surname).replace("false", "");

        } else if (!clientUtils.phoneNumberCheck(phoneNumber).equals("true")) {

            return "Bad phone number word " + clientUtils.phoneNumberCheck(phoneNumber).replace("false", "");

        } else {
            clients = clientService.findAll();

            for (Client client : clients) {

                if (client.getName().equals(name)) {

                    return "This name already used!";
                }
            }

            try {

                Float.parseFloat(price);
            } catch (NumberFormatException e) {
                return "Input correct price value!\n" +
                        "Its must have only numbers";

            }
        }


        return "successful";
    }
}

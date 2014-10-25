package hw11.controller.admin;

import hw11.model.domain.Client;
import hw11.service.client.ClientService;
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
 * Project name: proff16
 * User: Partizanin
 * Date: 21.09.2014
 * Time:  11:54
 * To change this template use File|Setting|File Templates.
 */
@Controller
@WebServlet("/ClientTable")
public class ClientTableServlet extends HttpServlet {

    private WebApplicationContext context;
    private ClientService clientService;

    private List<Client> clients = new ArrayList<Client>(10);


    @Override
    public void init()
            throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        clientService = (ClientService) context.getBean("clientServiceImpl");
        clients = clientService.findAll();


        String action = request.getParameter("action");

        if (action.equals("Return")) {
            request.getRequestDispatcher("/hw11/jsp/admins/enterAdmin.jsp").forward(request, response);
        }

        String client_id = request.getParameter("clientnId");
        String client_name = request.getParameter("clientName");
        String client_surname = request.getParameter("clientSurname");
        String client_phoneNumber = request.getParameter("clientPhonenumber");
        String client_address = request.getParameter("clientAdress");
        String client_summa = request.getParameter("clientSumma");
        String client_lastDate = request.getParameter("clientLastDate");
        Long clientId = 0l;
        Double clientSum = 0.0;
        String message = "";


        Client client = new Client();

        client.setName(client_name);
        client.setPhoneNumber(client_phoneNumber);
        client.setSurname(client_surname);
        client.setAddress(client_address);

        client.setLastDate(client_lastDate);

        if (client_id != null && !client_id.equals("")) {

            try {
                clientId = Long.parseLong(client_id);
                client.setId(clientId);
            } catch (NumberFormatException e) {
                message = "Pleas input correct id";
                request.setAttribute("message", message);
                request.setAttribute("clientList", clients);
                request.setAttribute("client", client);

                request.getRequestDispatcher("/hw11/jsp/admins/functions/clientsList.jsp").forward(request, response);

            }

        }

        if (client_summa != null && !client_summa.equals("")) {
            try {
                clientSum = Double.parseDouble(client_summa);
                client.setSumma(clientSum);
            } catch (NumberFormatException e) {
                message = "Pleas input correct summa";
                request.setAttribute("message", message);
                request.setAttribute("clientList", clients);
                request.setAttribute("client", client);

                request.getRequestDispatcher("/hw11/jsp/admins/functions/clientsList.jsp").forward(request, response);

            }
        }

        if (clients.size() < 1 && !action.equals("Add")) {
            request.setAttribute("message", "The list does not have administrator, add one");
            request.getRequestDispatcher("/hw11/jsp/admins/functions/clientsList.jsp").forward(request, response);

/*
            Client client1 = new Client("Vasa", "Petrov", "+380718032543", "Krasnoyarskaya/37", 20.00, "12.05.2014");
            client1.setId(1l);
            clients.add(client1);

            client1 = new Client("Oleg", "Bodrov", "+380652941636", "Mayskaya/56", 23.45, "23.07.2014");
            client1.setId(2l);
            clients.add(client1);


            client1 = new Client("Maksim", "LOmov", "+380528850725", "Vokzalnaya/69", 67.34, "13.05.2014");
            client1.setId(3l);
            clients.add(client1);

            client1 = new Client("Ivan", "Mishutin", "+380438769814", "Moskovskaya/92", 56.44, "18.02.2014");
            client1.setId(4l);
            clients.add(client1);
*/
        }


        switch (action) {
            case "Add":

                message = clientAdd(client);

                break;
            case "Edit":
                message = editClient(client);

                break;
            case "Delete":

                message = deleteClient(client);

                break;
            case "Search":

                client = searchClient(client);
                break;

        }
        clients = clientService.findAll();
        request.setAttribute("clientList", clients);
        request.setAttribute("message", message);
        request.setAttribute("client", client);
        request.getRequestDispatcher("/hw11/jsp/admins/functions/clientsList.jsp").forward(request, response);

    }


    private String deleteClient(Client client) {

        if (client.getId() == null || client.getId() == 0) {
            return "Pleas input id what you want delete!";

        }
        boolean idContain = false;

        for (Client client2 : clients) {
            if (client.getId().equals(client2.getId())) {
                idContain = true;
                break;
            }
        }

        if (!idContain) {
            return "Client with this id don't exist!";
        }
        for (Client client1 : clients) {

            if (client1.getId().equals(client.getId())) {

                /*clients.remove(i);*/
                clientService.delete(client1);
                break;
            }
        }
        return "";
    }

    private String editClient(Client client) {
        Client client1 = searchClient(client);

        if (client.getId() == null || client.getId() == 0) {
            return "Pleas input id what you want edit!";

        }


        client1.setSumma(client.getSumma());
        client1.setAddress(client.getAddress());
        client1.setSurname(client.getSurname());
        client1.setLastDate(client.getLastDate());
        client1.setName(client.getName());
        client1.setPhoneNumber(client.getPhoneNumber());

        for (int i = 0; i < clients.size(); i++) {

            if (clients.get(i).getId().equals(client1.getId())) {

                /*clients.set(i, client1);*/
                clientService.update(client1);
                break;
            }
        }

        return "";

    }

    private Client searchClient(Client client1) {
        Client client = new Client();
        boolean wasFiend = false;
        if (client1.getId() != null && client1.getId() != 0) {

            for (Client client2 : clients) {
                if (client1.getId().equals(client2.getId())) {

                    client = client2;
                    wasFiend = true;
                    break;
                }
            }
        } else if (client1.getName() != null && !client1.getName().equals("")) {
            for (Client client2 : clients) {
                if (client1.getName().equals(client2.getName())) {

                    client = client2;
                    wasFiend = true;
                    break;
                }
            }
        } else if (client1.getSurname() != null && !client1.getSurname().equals("")) {
            for (Client client2 : clients) {
                if (client1.getSurname().equals(client2.getSurname())) {

                    client = client2;
                    wasFiend = true;
                    break;
                }
            }
        } else if (client1.getPhoneNumber() != null && !client1.getPhoneNumber().equals("")) {
            for (Client client2 : clients) {
                if (client1.getPhoneNumber().equals(client2.getPhoneNumber())) {

                    client = client2;
                    wasFiend = true;
                    break;
                }
            }
        } else if (client1.getAddress() != null && !client1.getAddress().equals("")) {
            for (Client client2 : clients) {
                if (client1.getAddress().equals(client2.getAddress())) {

                    client = client2;
                    wasFiend = true;
                    break;
                }
            }
        } else if (client1.getLastDate() != null && !client1.getLastDate().equals("")) {
            for (Client client2 : clients) {
                if (client1.getLastDate().equals(client2.getLastDate())) {

                    client = client2;
                    wasFiend = true;
                    break;
                }
            }
        } else if (client1.getSumma() != 0.0) {
            for (Client client2 : clients) {
                if (client1.getSumma() == client2.getSumma()) {

                    client = client2;
                    wasFiend = true;
                    break;
                }
            }
        }

        if (!wasFiend) {
            long id = 0;
            int i = 0;


            for (int j = 0; j < clients.size(); j++) {

                if (clients.get(j).getId() > id) {
                    id = clients.get(j).getId();
                    i = j;
                }
            }
            client = clients.get(i);
        }
        return client;
    }

    private String clientAdd(Client client) {

        if (client.getId() == null || client.getId() == 0) {
            return "Pleas input correct id";
        } else {

            for (Client client1 : clients) {
                if (client.getId().equals(client1.getId())) {
                    return "Client with this id already exists,pleas input another id";
                } else if (client.getName().equals(client1.getName())) {
                    return "Client with this name already exists,pleas input another name";
                } else if (client.getSurname().equals(client1.getSurname())) {
                    return "Client with this surname already exists,pleas input another surname";
                } else if (client.getPhoneNumber().equals(client1.getPhoneNumber())) {
                    return "Client with this phone number already exists,pleas input another phone number";
                } else if (client.getAddress().equals(client1.getAddress())) {
                    return "client with this address already exists,pleas input another phone number";
                }
            }
        }
        /*clients.add(client);*/
        clientService.create(client);
        return "";

    }
}

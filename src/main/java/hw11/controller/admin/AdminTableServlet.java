package hw11.controller.admin;

import hw11.model.domain.Administrator;
import hw11.service.admin.AdminService;
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
@WebServlet("/AdminTable")
public class AdminTableServlet extends HttpServlet {

    private WebApplicationContext context;

    private AdminService adminService;


    private List<Administrator> adminList = new ArrayList<Administrator>(10);

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


        adminService = (AdminService) context.getBean("adminServiceImpl");
        adminList = adminService.findAll();


        String action = request.getParameter("action");
        if (action.equals("Return")) {
            request.getRequestDispatcher("/hw11/jsp/admins/enterAdmin.jsp").forward(request, response);
        }

        String adminID = request.getParameter("adminId");
        String adminLogin = request.getParameter("adminLogin");
        String adminInvitor = request.getParameter("adminInvitor");
        String adminPass = request.getParameter("adminPass");
        Long adminid = 0l;


        Administrator admin = new Administrator();

        admin.setLogin(adminLogin);
        admin.setPassword(adminPass);
        admin.setLoginAnotherAdmin(adminInvitor);
        String message = "";

        if (adminID != null && !adminID.equals("")) {
            try {
                adminid = Long.parseLong(adminID);
                admin.setId(adminid);
            } catch (NumberFormatException e) {
                message = "Pleas input correct id";
                request.setAttribute("adminList", adminList);
                request.setAttribute("message", message);
                request.setAttribute("admin", admin);
                request.getRequestDispatcher("/hw11/jsp/admins/functions/adminsList.jsp").forward(request, response);
            }


        }
        if (adminList.size() < 1 && !action.equals("Add")) {
            request.setAttribute("message", "The list does not have administrator, add one");
            request.getRequestDispatcher("/hw11/jsp/admins/functions/adminsList.jsp").forward(request, response);
        }


        switch (action) {
            case "Add":

                message = adminAdd(admin);

                break;
            case "Edit":

                message = editAdmin(admin);

                break;
            case "Delete":

                message = deleteAdmin(admin);

                break;
            case "Search":

                admin = searchAdmin(admin);
                break;
        }

        adminList = adminService.findAll();
        request.setAttribute("adminList", adminList);
        request.setAttribute("message", message);
        request.setAttribute("admin", admin);
        request.getRequestDispatcher("/hw11/jsp/admins/functions/adminsList.jsp").forward(request, response);


    }


    private String deleteAdmin(Administrator admin) {

        if (admin.getId() == null || admin.getId() == 0) {
            return "Pleas input id what you want delete!";
        }

        boolean idContain = false;
        for (Administrator anAdminList1 : adminList) {

            if (anAdminList1.getId().equals(admin.getId())) {
                idContain = true;
                break;
            }
        }


        if (!idContain) {
            return "Admin with this id don't exist!";
        }

        for (Administrator anAdminList : adminList) {

            if (anAdminList.getId().equals(admin.getId())) {

                /*adminList.remove(i);*/
                adminService.delete(anAdminList);
                break;
            }
        }

        return "";
    }

    private String editAdmin(Administrator admin) {

        Administrator administrator = searchAdmin(admin);

        boolean idContain = false;
        if (admin.getId() == null || admin.getId() == 0) {
            return "Pleas input id what you want edit!";
        }


        for (Administrator anAdminList1 : adminList) {

            if (anAdminList1.getId().equals(admin.getId())) {
                idContain = true;
                break;
            }
        }


        if (!idContain) {
            return "Admin with this id don't exist!";
        }


        int id = 0;

        for (int i = 0; i < adminList.size(); i++) {

            if (adminList.get(i).getId().equals(admin.getId())) {
                id = i;
                break;
            }
        }


        if (!adminList.get(id).getLogin().
                equals(admin.getLogin())) {

            for (Administrator anAdminList : adminList) {

                if (admin.getLogin().equals(anAdminList.getLogin())) {

                    return "Admin with this login already exits!\nPleas select another login!";
                }
            }
        }

        administrator.setLoginAnotherAdmin(admin.getLoginAnotherAdmin());
        administrator.setLogin(admin.getLogin());
        administrator.setPassword(admin.getPassword());

        for (Administrator anAdminList : adminList) {

            if (anAdminList.getId().equals(administrator.getId())) {

                /*adminList.set(i,administrator);*/
                adminService.update(administrator);
                break;
            }
        }

        return "";
    }

    private Administrator searchAdmin(Administrator admin) {
        Administrator administrator = new Administrator();

        boolean wasFiend = false;
        if (admin.getId() != null && admin.getId() != 0) {


            for (Administrator anAdminList : adminList) {

                if (anAdminList.getId().equals(admin.getId())) {

                    administrator = anAdminList;
                    wasFiend = true;
                    break;
                }
            }

        } else if (admin.getLogin() != null && !admin.getLogin().equals("")) {

            for (Administrator anAdminList : adminList) {

                if (anAdminList.getLogin().equals(admin.getLogin())) {

                    administrator = anAdminList;
                    wasFiend = true;
                    break;
                }
            }
        } else if (admin.getPassword() != null && !admin.getPassword().equals("")) {

            for (Administrator anAdminList : adminList) {

                if (anAdminList.getPassword().equals(admin.getPassword())) {

                    administrator = anAdminList;
                    wasFiend = true;
                    break;
                }
            }
        } else if (admin.getLoginAnotherAdmin() != null && !admin.getLoginAnotherAdmin().equals("")) {

            for (Administrator anAdminList : adminList) {

                if (anAdminList.getLoginAnotherAdmin().equals(admin.getLoginAnotherAdmin())) {

                    administrator = anAdminList;
                    wasFiend = true;
                    break;
                }
            }
        }

        if (!wasFiend) {


            long id = 0;
            int i = 0;


            for (int j = 0; j < adminList.size(); j++) {
                if (adminList.get(j).getId() > id) {
                    id = adminList.get(i).getId();
                    i = j;
                }
            }

            administrator = adminList.get(i);
        }
        return administrator;
    }

    private String adminAdd(Administrator admin) {

        boolean invitor = false;
        if (admin.getId() != null && admin.getId() != 0) {
            for (Administrator anAdminList : adminList) {
                if (admin.getLoginAnotherAdmin().equals(anAdminList.getLogin())) {
                    invitor = true;
                }
                if (admin.getId().equals(anAdminList.getId())) {
                    return "This id already use,pleas input another id";
                } else if (admin.getLogin().equals(anAdminList.getLogin())) {
                    return "This login already use,pleas input another login";
                }


            }
        } else {
            return "Pleas input id!!!";
        }

        if (!invitor) {
            return "Invitor does not exist!";
        }

        /*adminList.add(admin);*/
        adminService.create(admin);
        return "";
    }
}

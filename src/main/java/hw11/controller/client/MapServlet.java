package hw11.controller.client;

import hw11.model.domain.Administrator;
import hw11.service.admin.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 22.07.2014
 * Time: 15:12
 * To change this template use File|Setting|File Templates.
 */
@Controller
@WebServlet("/MapServlet")
public class MapServlet extends HttpServlet {

    private WebApplicationContext context;

    private AdminService adminService;

    private List<Administrator> adminList = new ArrayList<>(10);

    @Override
    public void init() throws ServletException {
  /*      Locale.setDefault(Locale.ENGLISH);
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}

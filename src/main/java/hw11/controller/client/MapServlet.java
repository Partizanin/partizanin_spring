package hw11.controller.client;

import hw11.model.domain.Administrator;
import hw11.service.admin.AdminService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
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
@WebServlet(
        name = "MapServlet",
        urlPatterns = "/MapServlet"
)
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

        System.out.println(LocalTime.now() + " hello from servlet");
        String site = "hw11/jsp/clients/jsp/сreateOrder.html";


        PrintWriter writer = response.getWriter();

        JSONObject catchObject = new JSONObject();

        String distance = "";
        String cost = "";
        String start = "";
        String finish = "";

        try {
            catchObject = new JSONObject(request.getParameter("json_string"));
            distance = String.valueOf(catchObject.get("distance"));
            cost = String.valueOf(catchObject.get("cost"));
            start = String.valueOf(catchObject.get("start"));
            finish = String.valueOf(catchObject.get("finish"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /*method which takes the value from page and redirect to another page */
        System.out.println(distance + "\n " +
                "" + cost + "\n" +
                "" + start + "\n" +
                "" + finish + "\n");

        response.sendRedirect("hw11/jsp/clients/jsp/сreateOrder.html");
    }
}

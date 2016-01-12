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
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: partizanin_spring
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();


        JSONObject catchObject = new JSONObject();
        JSONObject sendObject = new JSONObject();
        JSONObject requestValue = new JSONObject();
        String cost = "", distance = "", startPoint = "", finishPoint = "";


        try {
            catchObject = new JSONObject(request.getParameter("jsonData"));
            requestValue = catchObject.getJSONObject("operationCall");
            cost = requestValue.getString("cost");
            distance = requestValue.getString("distance");
            startPoint = requestValue.getString("startPoint");
            finishPoint = requestValue.getString("finishPoint");
            sendObject.accumulate("requestStatus", "Success");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        writer.println(sendObject);
        writer.flush();
        /*method which takes the value from page and redirect to another page */
        System.out.println(distance + "\n " +
                "" + cost + "\n" +
                "" + startPoint + "\n" +
                "" + finishPoint + "\n");
    }
}

package MyHome.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//에너테이션
@WebServlet(name = "MyHome", urlPatterns = "/")
public class MyHomeServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
        rd.forward(req, resp);
/*
        String actionName = req.getParameter("a");

        if ("form".equals(actionName)) {
            RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
            rd.forward(req, resp);
        } else {


            RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
            rd.forward(req, resp);
        }*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

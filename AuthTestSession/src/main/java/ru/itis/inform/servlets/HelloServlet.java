package ru.itis.inform.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artur on 13.11.16.
 */

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", req.getSession().getAttribute("session_username"));
        getServletConfig().getServletContext().getRequestDispatcher("/views/hello.jsp").forward(req,resp);
    }
}

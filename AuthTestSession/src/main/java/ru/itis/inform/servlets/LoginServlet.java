package ru.itis.inform.servlets;

import ru.itis.inform.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by artur on 13.11.16.
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    User user = new User();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("session_username") == null) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
        else {
            resp.sendRedirect("/hello");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(user.identify(username, password)) {
            req.getSession().setAttribute("session_username", username);
            resp.sendRedirect("/hello");
        }
        else{
            resp.sendRedirect("/login");
        }
    }
}

package ru.itis.inform.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by artur on 13.11.16.
 */
public class AuthFilter implements Filter {

    private String allowedUrl;

    public void init(FilterConfig filterConfig) throws ServletException {
        allowedUrl = filterConfig.getInitParameter("allowedUrl");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String servletPath = req.getServletPath();

        if (!allowedUrl.equals(servletPath)) {
            HttpSession session = req.getSession(false);

            if (session == null || session.getAttribute("session_username") == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/login.jsp");
                dispatcher.forward(request, response);
            }
            else {
                chain.doFilter(request, response);
            }
        }
        else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}

package main.controllers;

import main.models.pojo.User;
import main.services.UserService;
import main.services.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 19.04.2017.
 */
public class LoginController extends HttpServlet {
    private static Logger logger = Logger.getLogger(LoginController.class);
    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLogin = (String) req.getSession().getAttribute("userLogin");
        if (userLogin != null) {
            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userService.auth(login, password);
        if (user != null) {
            req.getSession().setAttribute("userLogin", login);
            if (user.isIs_admin()) {
                req.getSession().setAttribute("isAdmin", "1");
            }
            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            req.setAttribute("errorMsg", "failed login");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(req, resp);
        }

    }
}

package main.controllers;

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
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        logger.debug("login: " + login + " password: "+password );

        if (userService.auth(login, password) != null) {
            req.getSession().setAttribute("userLogin", login);
            logger.debug("user: " + login + " is logged" );
            resp.sendRedirect(req.getContextPath() + "/main");
        }

        logger.debug("user: " + login + " is not loggin" );
    }
}

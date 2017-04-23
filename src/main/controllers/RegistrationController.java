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
public class RegistrationController extends HttpServlet {
    private static Logger logger = Logger.getLogger(RegistrationController.class);
    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLogin = (String) req.getSession().getAttribute("userLogin");
        if (userLogin != null) {
            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean successReg = false;

        logger.debug("mail="+req.getParameter("mail")+"password="+req.getParameter("password"));
        logger.debug("firstName="+req.getParameter("firstName")+"lastName="+req.getParameter("lastName"));
        logger.debug(Integer.valueOf(req.getParameter("limit")));

        successReg = userService.registration(req.getParameter("mail"),
                req.getParameter("password"),
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                Integer.valueOf(req.getParameter("limit")));

        logger.debug("successReg="+successReg);
        if (successReg) {
            req.getSession().setAttribute("userLogin", req.getParameter("login"));
            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }
}

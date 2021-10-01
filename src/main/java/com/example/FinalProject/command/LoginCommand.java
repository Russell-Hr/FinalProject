package com.example.FinalProject.command;

import com.example.FinalProject.DBException;
import com.example.FinalProject.entity.User;
import com.example.FinalProject.UserManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    private static final Logger log = LogManager.getLogger(LoginCommand.class);
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String address = "login.jsp";
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserManager userManager = UserManager.getInstance();
        User user = userManager.getUser(login);
        if (user != null && user.getPassword().equals(password)) {
            if (user.getRole().equals("user")) {
                address = "my_parcel_start.jsp";
                req.getSession().setAttribute("role", user.getRole());
            }
            if (user.getRole().equals("manager")) {
                address = "all_parcel_start.jsp";
                req.getSession().setAttribute("role", user.getRole());
            }
            req.getSession().setAttribute("loggedUser", user);
        }
        return address;
    }
}
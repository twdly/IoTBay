package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "registerController", value = "/register")
public class RegisterController extends BaseServlet {

    @Override
    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serveJSP(request, response, "register.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String name = request.getParameter("firstname") + " " + request.getParameter("lastname");
        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("passwordCheck");

        if (validateRegistration(request, email, password, passwordCheck)) {
            Customer customer = new Customer(name, password);
            session.setAttribute("user", customer);
            serveJSP(request, response, "welcome.jsp");
        }
    }

    @Override
    public void destroy() {
    }

    private boolean validateRegistration(HttpServletRequest request, String email, String password, String passwordCheck) {
        boolean isValid = true;
        List<String> errors = new ArrayList<>();
        if (!email.contains("@")) {
            errors.add("Email is not valid");
            isValid = false;
        }
        if (!password.equals(passwordCheck)) {
            errors.add("Passwords do not match");
            isValid = false;
        }
        if (password.length() < 8) {
            errors.add("Password is less than 8 characters");
            isValid = false;
        }

        if (!isValid) {
            request.setAttribute("errors", errors);
        }
        return isValid;
    }
}

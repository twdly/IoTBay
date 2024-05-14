package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.UserDao;
import isdwrk04.group5.iotbay.model.User;
import isdwrk04.group5.iotbay.service.HashingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "registerController", value = "/register")
public class RegisterController extends BaseServlet {

    private HashingService hashingService;
    private UserDao userDao;

    @Override
    public void init() {
        this.userDao = new UserDao();
        try {
            hashingService = new HashingService();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            serveJSP(request, response, "welcome.jsp");
        } else {
            serveJSP(request, response, "register.jsp");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String name = request.getParameter("firstname") + " " + request.getParameter("lastname");
        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("passwordCheck");
        String phone = request.getParameter("phoneNumber");

        if (validateRegistration(session, email, password, passwordCheck, phone)) {
            byte[] salt = hashingService.createSalt();
            byte[] hashedPassword;

            try {
                hashedPassword = hashingService.hashPassword(salt, password);
            } catch (InvalidKeySpecException e) {
                throw new RuntimeException(e);
            }

            User customer = new User(name, email, salt, hashedPassword, User.Role.Customer, phone);
            userDao.addUser(customer);
            session.setAttribute("user", customer);

            serveJSP(request, response, "welcome.jsp");
        } else {
            serveJSP(request, response, "register.jsp");
        }
    }

    @Override
    public void destroy() {
    }

    private boolean validateRegistration(HttpSession session, String email, String password, String passwordCheck, String phone) {
        boolean isValid = true;
        List<String> errors = new ArrayList<>();
        if (!email.contains("@")) {
            errors.add("Email is not valid");
            isValid = false;
        }
        if (userDao.getUserByEmail(email) != null) {
            errors.add("This email has already been used");
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
        if (!phone.matches("\\d{10}")) {
            errors.add("Phone number must be a 10-digit number.");
            isValid = false;
        }

        if (!isValid) {
            session.setAttribute("errors", errors);
        }
        return isValid;
    }
}

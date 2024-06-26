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
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// Handles account management related operations:
// update account details, update password, account deletion

@WebServlet( name= "updateAccountController", value = "/update-account" )
public class UpdateAccountController extends BaseServlet {

//    Initialize the servlet by creating instances of HashingService and UserDao

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

//    Handle GET requests to the servlet
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
//        Redirect to the login page if the user is not logged in
        if (null == user) {
            redirectToUrl(request, response, "/login");
            return;
        }
        serveJSP(request, response, "updateAccount.jsp");
    }

//    Handle POST requests to the servlet
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

//         Retrieve 'action' parameter and perform operations based on the 'action' parameter
        String action = request.getParameter("action");

        if ("updateDetails".equals(action)) {
            updateDetails(request, response, user, session);
        } else if ("updatePassword".equals(action)) {
            updatePassword(request, response, user, session);
        } else if ("deactivate".equals(action)) {
            deactivateAccount(request, response, user, session);
        } else {
            session.setAttribute("errors", Collections.singletonList("Invalid action."));
            serveJSP(request, response, "updateAccount.jsp");
        }
    }

//    Update user details based on the form input
    public void updateDetails(HttpServletRequest request, HttpServletResponse response, User user, HttpSession session) throws ServletException, IOException {

        String email = request.getParameter("email");
        String name = request.getParameter("firstname") + " " + request.getParameter("lastname");
        String phone = request.getParameter("phoneNumber");

        if (validateDetails(session, email, name, phone)) {
            user.setEmail(email);
            user.setUsername(name);
            user.setPhoneNo(phone);
//            Update the user's details in the database
            userDao.updateUserDetails(user);
            serveJSP(request, response, "updateAccount.jsp");
        } else {
            serveJSP(request, response, "updateAccount.jsp");
        }
    }

//    Update user password based on the form input
    public void updatePassword(HttpServletRequest request, HttpServletResponse response, User user, HttpSession session) throws ServletException, IOException {
        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("passwordCheck");

        if (validatePassword(session, password, passwordCheck)) {
            byte[] salt = hashingService.createSalt();
            byte[] hashedPassword;

            try {
                hashedPassword = hashingService.hashPassword(salt, password);
            } catch (InvalidKeySpecException e) {
                throw new RuntimeException(e);
            }

            user.setHashedPassword(hashedPassword);
            user.setSalt(salt);
//            Update the user's details in the database
            userDao.updateUserDetails(user);
            serveJSP(request, response, "updateAccount.jsp");
        } else {
            serveJSP(request, response, "updateAccount.jsp");
        }
    }

//    Deactivate user account
    public void deactivateAccount(HttpServletRequest request, HttpServletResponse response, User user, HttpSession session) {
//        Set a placeholder value for deletion
        String str = "deleted";
//        Convert the placeholder string to a byte array
        byte[] byteArray = str.getBytes(StandardCharsets.UTF_8);
//        Set the user's email, username, phone number, hashed password, and salt to the placeholder values
        user.setEmail(str);
        user.setUsername(str);
        user.setPhoneNo(str);
        user.setHashedPassword(byteArray);
        user.setSalt(byteArray);

//        Update the user's details in the database
        userDao.updateUserDetails(user);
        request.getSession(false).invalidate();

        try {
            response.sendRedirect(request.getContextPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

//    Validate user details (email, name, phone number)
    private boolean validateDetails(HttpSession session, String email, String name, String phone) {
        boolean isValid = true;
        List<String> errors = new ArrayList<>();
        if (!email.contains("@")) {
            errors.add("Email is not valid");
            isValid = false;
        }
        if (!phone.matches("\\d{10}") || phone.length() != 10) {
            errors.add("Phone number can only contain 10-digit number.");
            isValid = false;
        }
        if (!isValid) {
            session.setAttribute("errors", errors);
        }
        return isValid;
    }

//    Validate user password
    private boolean validatePassword(HttpSession session, String password, String passwordCheck) {
        boolean isValid = true;
        List<String> errors = new ArrayList<>();
        if (!password.equals(passwordCheck)) {
            errors.add("Passwords do not match");
            isValid = false;
        }
        if (password.length() < 8) {
            errors.add("Password is less than 8 characters");
            isValid = false;
        }
        if (!isValid) {
            session.setAttribute("errors", errors);
        }
        return isValid;
    }

}

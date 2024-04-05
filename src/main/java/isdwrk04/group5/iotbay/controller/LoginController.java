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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "loginController", value = "/login")
public class LoginController extends BaseServlet {

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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        serveJSP(request, response, "login.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDao.getUserByEmail(email);
        if (user != null) {
            HttpSession session = request.getSession();
            if (hashingService.checkPassword(user, password)) {
                session.setAttribute("user", user);
                serveJSP(request, response, "welcome.jsp");
            } else {
                errors.add("Invalid password");
            }
        } else {
            errors.add("Invalid email");
        }
        if (!errors.isEmpty()) {
            request.getSession().setAttribute("errors", errors);
            serveJSP(request, response, "login.jsp");
        }
    }

    @Override
    public void destroy() {
    }
}

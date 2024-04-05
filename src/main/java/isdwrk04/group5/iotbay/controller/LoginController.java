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
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");

        User user = userDao.getUserByEmail(email);
        if (user != null) {
            HttpSession session = request.getSession();
            if (hashingService.checkPassword(user, password)) {
                session.setAttribute("user", user);
                serveJSP(request, response, "welcome.jsp");
            }
            response.sendRedirect("welcome.jsp");
        } else {
            request.setAttribute("errors", "Invalid email or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}

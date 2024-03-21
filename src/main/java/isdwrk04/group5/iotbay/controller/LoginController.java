package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginController", value = "/login")
public class LoginController extends BaseServlet {

    @Override
    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        serveJSP(request, response, "login.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.getSession().setAttribute("user", new Customer(username, password));
        serveJSP(request, response, "welcome.jsp");
    }

    @Override
    public void destroy() {
    }
}

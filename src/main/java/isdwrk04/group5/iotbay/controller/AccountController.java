package isdwrk04.group5.iotbay.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;

@WebServlet(name = "accountController", value = "/account")
public class AccountController extends BaseServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {
            session.setAttribute("errors", Collections.singletonList("You must be logged in to view this page."));
            serveJSP(request, response, "login.jsp");
        } else {
            serveJSP(request, response, "account.jsp");
        }

    }

    public void destroy() {
    }
}

package isdwrk04.group5.iotbay.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

@WebServlet(name = "logoutController", value = "/logout")
public class LogoutController extends BaseServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        request.getSession(false).invalidate();
        try {
            response.sendRedirect(request.getContextPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}

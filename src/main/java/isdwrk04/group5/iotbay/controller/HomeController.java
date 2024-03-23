package isdwrk04.group5.iotbay.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "homeController", value = "")
public class HomeController extends BaseServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        serveJSP(request, response, "home.jsp");
    }

    public void destroy() {
    }
}

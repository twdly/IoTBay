package isdwrk04.group5.iotbay.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    /**
     * Method used to redirect the user to the given jsp without updating the URL
     * @param jspName the name of the jsp file to redirect to
     */
    protected void serveJSP(HttpServletRequest request, HttpServletResponse response, String jspName) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/" + jspName).include(request, response);
    }
}

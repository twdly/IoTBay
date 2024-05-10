package isdwrk04.group5.iotbay.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    public final String USER_ATTRIBUTE = "user";

    /**
     * Method used to redirect the user to the given jsp without updating the URL
     * Use redirectToUrl instead if you expect the controller method for the page to run
     * @param jspName the name of the jsp file to redirect to
     */
    protected void serveJSP(HttpServletRequest request, HttpServletResponse response, String jspName) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/" + jspName).include(request, response);
    }

    /**
     * Method used to redirect the user to a given URL.
     * This allows the user to be redirected while running the controller for the given page
     * @param url The URL of the controller to redirect to (with leading /)
     */
    protected void redirectToUrl(HttpServletRequest request, HttpServletResponse response, String url) {
        try {
            response.sendRedirect(request.getContextPath() + url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

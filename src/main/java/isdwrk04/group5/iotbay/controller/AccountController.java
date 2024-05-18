package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.AccessLogDAO;
import isdwrk04.group5.iotbay.model.AccessLog;
import isdwrk04.group5.iotbay.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

//Handles the access log related operations

@WebServlet(name = "accountController", value = "/account")
public class AccountController extends BaseServlet {

    private AccessLogDAO logDao;

//    Initializes the servlet by creating an instance of AccessLogDAO

    @Override
    public void init() {
        this.logDao = new AccessLogDAO();
    }

//    Handles GET requests. Retrieves the user logs if the user is logged in
//    If the user is not logged in, redirects to the login page

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) request.getSession().getAttribute("user");

//        If the user is not logged in, redirect to the login page with an error message
        if (session.getAttribute("user") == null) {
            session.setAttribute("errors", Collections.singletonList("You must be logged in to view this page."));
            serveJSP(request, response, "login.jsp");
        } else {
//            If the user is logged in, retrieve the user's access logs and display them on the account page
            int id = user.getId();
            List<AccessLog> userLogs = logDao.getLogsByUser(id);
//            Set the user logs as a request attribute and forward to the account JSP page
            request.setAttribute("userLogs", userLogs);
            serveJSP(request, response, "account.jsp");
        }
    }

//    Handles POST requests. Retrieves the user logs based on the specified date.
//    If no date is specified, retrieves all logs for the user.

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String date = request.getParameter("date");
        int id = user.getId();
        List<AccessLog> userLogs;
//        If no date is specified, retrieve all logs for the user
        if (date.equals("")) {
            userLogs = logDao.getLogsByUser(id);
        } else {
//            If a date is specified, retrieve logs for that specific date
            userLogs = logDao.getLogsByDate(id, date);
        }
//        Set the user logs as a request attribute and forward to the account JSP page
        request.setAttribute("userLogs", userLogs);
        serveJSP(request, response, "account.jsp");

    }

    public void destroy() {
    }
}

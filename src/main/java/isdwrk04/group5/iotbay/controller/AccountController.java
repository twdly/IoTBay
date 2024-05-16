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

@WebServlet(name = "accountController", value = "/account")
public class AccountController extends BaseServlet {

    private AccessLogDAO logDao;

    @Override
    public void init() {
        this.logDao = new AccessLogDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) request.getSession().getAttribute("user");

        if (session.getAttribute("user") == null) {
            session.setAttribute("errors", Collections.singletonList("You must be logged in to view this page."));
            serveJSP(request, response, "login.jsp");
        } else {
            int id = user.getId();
            List<AccessLog> userLogs = logDao.getLogsByUser(id);
            request.setAttribute("userLogs", userLogs);
            serveJSP(request, response, "account.jsp");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String date = request.getParameter("date");
        int id = user.getId();
        List<AccessLog> userLogs;
        if (date.equals("")) {
            userLogs = logDao.getLogsByUser(id);
        } else {
            userLogs = logDao.getLogsByDate(id, date);
        }
        request.setAttribute("userLogs", userLogs);
        serveJSP(request, response, "account.jsp");

    }

    public void destroy() {
    }
}

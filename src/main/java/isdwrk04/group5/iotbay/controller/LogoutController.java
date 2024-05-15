package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.AccessLogDAO;
import isdwrk04.group5.iotbay.model.AccessLog;
import isdwrk04.group5.iotbay.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logoutController", value = "/logout")
public class LogoutController extends BaseServlet {

    private AccessLogDAO logDao;

    public void init() {
        this.logDao = new AccessLogDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        request.getSession(false).invalidate();
        AccessLog log = new AccessLog(user.getId(), "login");
        logDao.insertLog(log);

        try {
            response.sendRedirect(request.getContextPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}

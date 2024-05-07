package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.OrderDao;
import isdwrk04.group5.iotbay.model.Order;
import isdwrk04.group5.iotbay.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( name="ordersController", value = "/orders")
public class OrdersController extends BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        if (null == user) {
            redirectToUrl(request, response, "/login");
            return;
        }

        OrderDao dao = new OrderDao();
        List<Order> orders = dao.getOrdersForUser(user.getId());
        request.setAttribute("orders", orders);

        serveJSP(request, response, "orders.jsp");
    }
}

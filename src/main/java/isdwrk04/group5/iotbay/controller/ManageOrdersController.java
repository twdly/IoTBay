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

@WebServlet( name = "manageOrdersController", value = "/manage-orders")
public class ManageOrdersController extends BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getRole().equals(User.Role.Staff)) {
            redirectToUrl(request, response, "/");
            return;
        }
        OrderDao dao = new OrderDao();
        List<Order> orders = dao.getOrderByStatus(Order.Status.Processing);
        request.setAttribute("orders" ,orders);
        serveJSP(request, response, "manageOrders.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        OrderDao dao = new OrderDao();
        Order order = dao.getOrderById(orderId);
        Order.Status newStatus = order.getMethod().equals(Order.Method.Delivery) ? Order.Status.Shipped : Order.Status.ReadyToCollect;
        dao.updateStatus(orderId, newStatus);
        redirectToUrl(request, response, "/manage-orders");
    }
}

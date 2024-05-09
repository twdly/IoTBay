package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.OrderDao;
import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.model.Order;
import isdwrk04.group5.iotbay.model.Product;
import isdwrk04.group5.iotbay.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( name = "viewOrderController", value = "/view-order")
public class ViewOrderController extends BaseServlet {

    public final String CANCEL_TYPE = "cancel";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (null == user) {
            serveJSP(request, response, "login.jsp");
            return;
        }
        setOrderAttributes(request, response, user, Integer.parseInt(request.getQueryString()), new OrderDao());
        serveJSP(request, response, "viewOrder.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestType = request.getParameter("type");

        if (requestType.equals(CANCEL_TYPE)) {
            int orderId;
            try {
                orderId = Integer.parseInt(request.getParameter("number"));
            } catch (NumberFormatException e) {
                response.sendError(400);
                return;
            }

            OrderDao dao = new OrderDao();
            Order orderToCancel = dao.getOrderById(orderId);
            User user = (User) request.getSession().getAttribute("user");
            if (orderToCancel == null || orderToCancel.getUserId() != user.getId()) {
                response.sendError(400);
                return;
            }

            dao.cancelOrder(orderId);
            setOrderAttributes(request, response, user, orderId, dao);

            serveJSP(request, response, "viewOrder.jsp");
        }
    }

    private void setOrderAttributes(HttpServletRequest request, HttpServletResponse response, User user, int orderId, OrderDao orderDao) throws IOException {
        ProductDao productDao = new ProductDao();

        Order order = orderDao.getOrderById(orderId);
        if (null == order) {
            response.sendError(404, "Order does not exist");
            return;
        }

        if (order.getUserId() != user.getId()) {
            response.sendError(403);
            return;
        }

        List<Product> products = productDao.getProductsFromOrder(order.getId());
        request.setAttribute("order", order);
        request.setAttribute("products", products);
    }
}

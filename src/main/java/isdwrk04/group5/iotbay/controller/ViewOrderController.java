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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (null == user) {
            serveJSP(request, response, "login.jsp");
            return;
        }

        OrderDao orderDao = new OrderDao();
        ProductDao productDao = new ProductDao();

        Order order = orderDao.getOrderById(Integer.parseInt(request.getQueryString()));

        if (null == order) {
            response.sendError(404, "Order does not exist");
            return;
        }

        List<Product> products = productDao.getProductsFromOrder(order.getId());

        if (order.getUserId() != user.getId()) {
            response.sendError(403);
            return;
        }

        request.setAttribute("order", order);
        request.setAttribute("products", products);

        serveJSP(request, response, "viewOrder.jsp");
    }
}

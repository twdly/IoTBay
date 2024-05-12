package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.OrderDao;
import isdwrk04.group5.iotbay.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( name = "confirmOrderController", value = "/confirm-order")
public class ConfirmOrderController extends BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = (Order) request.getSession().getAttribute("currentOrder");
        if (null == order) {
            redirectToUrl(request, response, "/cart");
        } else {
            serveJSP(request, response, "confirmOrder.jsp");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Order order = (Order) request.getSession().getAttribute("currentOrder");
        List<OrderLine> orderLineList = new ArrayList<>();
        for (Product product : cart.getProducts()) {
            // The orderID is not yet known hence -1 is used as an obviously wrong placeholder value
            orderLineList.add(new OrderLine(product.getQuantity(), -1, product.getId()));
        }
        OrderDao dao = new OrderDao();
        dao.placeOrder(order, orderLineList);
        request.getSession().removeAttribute("cart");
        request.getSession().removeAttribute("currentOrder");
        serveJSP(request, response, "postOrder.jsp");
    }
}

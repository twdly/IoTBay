package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.OrderDao;
import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( name = "confirmOrderController", value = "/confirmOrder")
public class ConfirmOrderController extends BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDetails paymentDetails = (PaymentDetails) request.getSession().getAttribute("paymentDetails");
        if (paymentDetails == null) {
            // Redirect to payment page if payment details are not present
            redirectToUrl(request, response, "/payment");
        } else {
            // If payment details are present, proceed with order confirmation
            Order order = (Order) request.getSession().getAttribute("currentOrder");
            if (order == null) {
                redirectToUrl(request, response, "/cart");
            } else {
                serveJSP(request, response, "/WEB-INF/confirmOrder.jsp");
            }
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
        OrderDao orderDao = new OrderDao();
        orderDao.placeOrder(order, orderLineList);
        ProductDao productDao = new ProductDao();
        productDao.reduceStockForOrder(orderLineList);
        request.getSession().removeAttribute("cart");
        request.getSession().removeAttribute("currentOrder");
        request.getSession().removeAttribute("paymentDetails");
        serveJSP(request, response, "postOrder.jsp");
    }
}
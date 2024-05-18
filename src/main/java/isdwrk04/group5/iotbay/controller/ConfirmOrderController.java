package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.OrderDao;
import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.dao.PaymentDao;
import isdwrk04.group5.iotbay.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "confirmOrderController", value = "/confirmOrder")
public class ConfirmOrderController extends BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDetails paymentDetails = (PaymentDetails) request.getSession().getAttribute("paymentDetails");
        if (paymentDetails == null) {
            // Redirect to payment controller to view payments if payment details are not present
            redirectToUrl(request, response, "/payment");
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
        OrderDao orderDao = new OrderDao();
        orderDao.placeOrder(order, orderLineList);
        ProductDao productDao = new ProductDao();
        productDao.reduceStockForOrder(orderLineList);

        // Retrieve payment details
        PaymentDao paymentDao = new PaymentDao();
        PaymentDetails paymentDetails = (PaymentDetails) request.getSession().getAttribute("paymentDetails");
        List<PaymentDetails> paymentDetailsList = paymentDao.getPaymentsByUserId(order.getUserId());

        // Set attributes for order and payment details
        request.setAttribute("order", order);
        request.setAttribute("orderLines", orderLineList);
        request.setAttribute("payments", paymentDetailsList);

        // Clear session attributes
        request.getSession().removeAttribute("cart");
        request.getSession().removeAttribute("currentOrder");

        // Forward to the confirmation page with order and payment details
        serveJSP(request, response, "/WEB-INF/confirmOrder.jsp");
    }
}


package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.model.Cart;
import isdwrk04.group5.iotbay.model.Order;
import isdwrk04.group5.iotbay.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( name = "placeOrderController", value = "/place-order")
public class PlaceOrderController extends BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (null == cart) {
            redirectToUrl(request, response, "/cart");
            return;
        }
        serveJSP(request, response, "placeOrder.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(USER_ATTRIBUTE);

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String method = request.getParameter("method");

        if (name.isEmpty() || phone.isEmpty() || method.isEmpty()) {
            List<String> errors = new ArrayList<>();
            errors.add("Please enter a name and a phone number.");
            request.getSession().setAttribute("errors", errors);
            serveJSP(request, response, "placeOrder.jsp");
            return;
        }

        Order order = new Order();
        order.setName(name);
        order.setPhoneNo(phone);
        order.setMethod(Order.Method.valueOf(method));
        if (null != user) {
            order.setUserId(user.getId());
        }
        request.getSession().setAttribute("currentOrder", order);

        // Change this following line here to redirect to shipment or payment controllers
        redirectToUrl(request, response, "/confirm-order");
    }
}

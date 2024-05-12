package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.model.Cart;
import isdwrk04.group5.iotbay.model.Order;
import isdwrk04.group5.iotbay.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute(USER_ATTRIBUTE);

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String method = request.getParameter("method");

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

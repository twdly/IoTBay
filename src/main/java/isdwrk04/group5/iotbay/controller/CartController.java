package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet( name = "cartController", value = "/cart")
public class CartController extends BaseServlet{

    public final String SAVE_BUTTON_VALUE = "Save changes";
    public final String CLEAR_BUTTON_VALUE = "Clear cart";
    public final String ORDER_BUTTON_VALUE = "Place order";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        serveJSP(request, response, "cart.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Action will be null if the remove button is clicked
        // Setting action to an empty string instead of null prevents the switch statement from throwing a NullPointerException
        String action = null == request.getParameter("action") ? "" : request.getParameter("action");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        switch (action) {
            case SAVE_BUTTON_VALUE:
                saveOrder(request, response, cart);
                break;
            case CLEAR_BUTTON_VALUE:
                clearCart(request, response, cart);
                break;
            case ORDER_BUTTON_VALUE:
                placeOrder(request, response, cart);
                break;
            default:
                removeItem(request, response, cart);
                break;
        }
    }

    private void removeItem(HttpServletRequest request, HttpServletResponse response, Cart cart) throws ServletException, IOException {
        Enumeration<String> parameters = request.getParameterNames();
        int index = -1;
        while (parameters.hasMoreElements()) {
            String element = parameters.nextElement();
            if (element.contains("remove")) {
                index = Integer.parseInt(element.replace("remove", ""));
            }
        }
        cart.removeProduct(index);
        request.getSession().setAttribute("cart", cart);
        serveJSP(request, response, "cart.jsp");
    }

    private void placeOrder(HttpServletRequest request, HttpServletResponse response, Cart cart) throws ServletException, IOException {
        updateQuantities(request, cart);
        request.getSession().setAttribute("cart", cart);
        serveJSP(request, response, "cart.jsp");
    }

    private void clearCart(HttpServletRequest request, HttpServletResponse response, Cart cart) throws ServletException, IOException {
        cart.clearCart();
        request.getSession().setAttribute("cart", cart);
        serveJSP(request, response, "cart.jsp");
    }

    private void saveOrder(HttpServletRequest request, HttpServletResponse response, Cart cart) throws ServletException, IOException {
        updateQuantities(request, cart);
        request.getSession().setAttribute("cart", cart);
        serveJSP(request, response, "cart.jsp");
    }

    private void updateQuantities(HttpServletRequest request, Cart cart) {
        int size = cart.getProducts().size();
        for (int i = 0; i < size; i++) {
            int quantity = Integer.parseInt(request.getParameter("item" + i));
            cart.updateQuantity(i, quantity);
        }
    }
}

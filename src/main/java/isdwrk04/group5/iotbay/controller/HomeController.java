package isdwrk04.group5.iotbay.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.model.Cart;
import isdwrk04.group5.iotbay.model.Product;


@WebServlet(name = "homeController", value = "")
public class HomeController extends BaseServlet {

    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductDao dao = new ProductDao();
        List<Product> products = dao.getAllProducts();

        // Set list of products as an attribute
        request.setAttribute("products", products);
        request.getSession().setAttribute("cart", new Cart());
        request.setAttribute("searchQuery", "asdfasdf");
        getServletContext();
        serveJSP(request, response, "home.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // This method is used to add items to the cart
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        ProductDao productDao = new ProductDao();

        serveJSP(request, response, "home.jsp");
    }

    public void destroy() {
    }
}

package isdwrk04.group5.iotbay.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import isdwrk04.group5.iotbay.model.Product;


@WebServlet(name = "homeController", value = "")
public class HomeController extends BaseServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Initalize example products
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            products.add(new Product("Product " + i, "Description of Product " + i, (i * 10 + 9.99)));
        }

        // Set list of products as an attribute
        request.setAttribute("products", products);

        serveJSP(request, response, "home.jsp");
    }

    public void destroy() {
    }
}

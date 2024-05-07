package isdwrk04.group5.iotbay.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.model.Product;


@WebServlet(name = "homeController", value = "")
public class HomeController extends BaseServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductDao dao = new ProductDao();
        List<Product> products = dao.getAllProducts();

        // Set list of products as an attribute
        request.setAttribute("products", products);

        serveJSP(request, response, "home.jsp");
    }

    public void destroy() {
    }
}

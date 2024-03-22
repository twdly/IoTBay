package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// Main page
@WebServlet(name = "storeController", value = "/store")
public class StoreController extends BaseServlet {
    List<Product> products;

    @Override
    public void init() {
        products = new ArrayList<>();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("products", products);
        serveJSP(request, response, "store.jsp");
    }
}

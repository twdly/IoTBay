package isdwrk04.group5.iotbay.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.model.Product;


@WebServlet(name = "homeController", value = {"", "/search"})
public class HomeController extends BaseServlet {

    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String query = request.getParameter("search");
        String category = request.getParameter("category");

        ProductDao dao = new ProductDao();
        List<Product> products;
        List<String> productCategories = dao.getProductCategories();

        if (query != null && !query.isEmpty()) {
            products = dao.getSearchProducts(query);
            request.setAttribute("searchQuery", query);
        } else if (category != null && !category.isEmpty()) {
            products = dao.getCategoryProducts(category);
            request.setAttribute("category", category);
        } else {
            products = dao.getAllProducts();
        }

        request.setAttribute("products", products);
        request.setAttribute("productCategories", productCategories);

        serveJSP(request, response, "home.jsp");
    }


    public void destroy() {
    }
}

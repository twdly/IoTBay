package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchController", value="/search")
public class SearchController extends BaseServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String query = request.getParameter("search");
        if (query != null && !query.isEmpty()) {
            ProductDao dao = new ProductDao();
            List<Product> products = dao.getSearchProducts(query);

            request.setAttribute("products", products);
            request.setAttribute("searchQuery", query);

            serveJSP(request, response, "home.jsp");
        } else {
            ProductDao dao = new ProductDao();
            List<Product> products = dao.getAllProducts();

            request.setAttribute("products", products);

            serveJSP(request, response, "home.jsp");
        }
    }
}

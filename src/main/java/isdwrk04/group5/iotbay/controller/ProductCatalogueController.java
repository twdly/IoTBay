package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.model.Product;
import isdwrk04.group5.iotbay.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( name="productCatalogueController", value = "/productCatalogue")
public class ProductCatalogueController extends BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        if (null == user) {
            redirectToUrl(request, response, "/login");
            return;
        }

        ProductDao dao = new ProductDao();
        List<Product> products;
        products = dao.getAllProducts();

        request.setAttribute("products", products);

        serveJSP(request, response, "productCatalogue.jsp");
    }
}

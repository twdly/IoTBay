package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.model.Product;
import isdwrk04.group5.iotbay.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
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

        if (!user.getRole().equals(User.Role.Staff)) {
            redirectToUrl(request, response, "/");
            return;
        }

        ProductDao dao = new ProductDao();
        List<Product> products;
        products = dao.getAllProducts();

        request.setAttribute("products", products);

        serveJSP(request, response, "productCatalogue.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao = new ProductDao();

        HttpSession session = request.getSession();

        String productName = request.getParameter("product-name");
        String productCategory = request.getParameter("product-category");
        String productDescription = request.getParameter("product-description");
        String productPriceStr = request.getParameter("product-price");
        String productStockStr = request.getParameter("product-stock");

        if (validateNewProduct(session, productName, productCategory, productDescription, productPriceStr, productStockStr)) {
            double productPrice = Double.parseDouble(productPriceStr);
            int productStock = Integer.parseInt(productStockStr);
            Product product = new Product(productName, productCategory, productDescription, productPrice, productStock);
            productDao.addProduct(product);
        }
        List<Product> products = productDao.getAllProducts();;
        request.setAttribute("products", products);
        serveJSP(request, response, "productCatalogue.jsp");
    }

    private boolean validateNewProduct(HttpSession session, String productName, String productCategory, String productDescription, String productPrice, String productStock) {
        boolean isValid = true;
        List<String> errors = new ArrayList<>();
        if (!productName.matches("^[a-zA-Z0-9()\\-\\s]+$")) {
            errors.add("Product name can only include letters, numbers and the symbols ( ) and -");
            isValid = false;
        }
        if (!productCategory.matches("^[a-zA-Z\\s]+$")) {
            errors.add("Product category can only contain letters");
            isValid = false;
        }
        if (!productDescription.matches("^[a-zA-Z0-9,.\\s'-]{1,200}$")) {
            errors.add("Product description can only include letters numbers , and . and must be under 200 characters");
            isValid = false;
        }
        if (!productPrice.matches("^[0-9]{1,5}(?:\\.[0-9]{2})?$")) {
            errors.add("Product price can only contain 1-5 numbers before the decimal - 00000.00");
            isValid = false;
        }
        if (!productStock.matches("^[0-9]+$")) {
            errors.add("Stock must be a number");
            isValid = false;
        }

        if (!isValid) {
            session.setAttribute("errors", errors);
        }
        return isValid;
    }
}

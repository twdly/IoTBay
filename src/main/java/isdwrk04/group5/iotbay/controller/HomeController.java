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

        request.getSession().setAttribute("cart", new Cart());
        request.setAttribute("products", products);
        request.setAttribute("productCategories", productCategories);

        serveJSP(request, response, "home.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // This method is used to add items to the cart
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        ProductDao productDao = new ProductDao();
        cart.addItem( productDao.getProductById(itemId));

        request.getSession().setAttribute("cart", cart);

        // This is necessary to redirect the user back to the current page they are on
        // Doing so allows all their currently viewed products to still display as if they were never redirected
        redirectToUrl(request, response, getRedirectUrl(request));
    }

    private static String getRedirectUrl(HttpServletRequest request) {
        String requestUrl = String.valueOf(request.getRequestURL());
        String contextPath = request.getContextPath();
        String query = request.getQueryString();
        return requestUrl.substring(requestUrl.indexOf(contextPath) + contextPath.length()) + (query != null ? "?" + query : "");
    }

    public void destroy() {
    }
}

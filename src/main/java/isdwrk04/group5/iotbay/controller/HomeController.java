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

    // the doGet for this controller was written by Ria and Tai
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // if there is a search query or a category has been selected the value is retrieved
        String query = request.getParameter("search");
        String category = request.getParameter("category");

        // a new ProductDao is initialised, a list of Product objects is declared,
        // and the product categories are retrieved from the ProductDao
        ProductDao dao = new ProductDao();
        List<Product> products;
        List<String> productCategories = dao.getProductCategories();

        // checks if there is a search query or a category
        // if there's a search query then runs the getSearchProducts function
        // if there's a category then runs the getCategoryProducts function
        // if there is neither then it retrieves all products
        // in other words, this changes the products displayed depending on whether the
        // user has searched, chosen a category, or just browsed to the home page
        if (query != null && !query.isEmpty()) {
            products = dao.getSearchProducts(query);
            request.setAttribute("searchQuery", query);
        } else if (category != null && !category.isEmpty()) {
            products = dao.getCategoryProducts(category);
            request.setAttribute("category", category);
        } else {
            products = dao.getAllProducts();
        }

        if (request.getAttribute("cart") == null) {
            request.setAttribute("cart", new Cart());
        }

        request.setAttribute("products", products);
        request.getSession().setAttribute("productCategories", productCategories);

        serveJSP(request, response, "home.jsp");
    }

    // the doPost for this controller was written by Tai
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
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

    // getRedirectUrl was written by Tai
    private static String getRedirectUrl(HttpServletRequest request) {
        String requestUrl = String.valueOf(request.getRequestURL());
        String contextPath = request.getContextPath();
        String query = request.getQueryString();
        return requestUrl.substring(requestUrl.indexOf(contextPath) + contextPath.length()) + (query != null ? "?" + query : "");
    }
}

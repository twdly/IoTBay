package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.OrderDao;
import isdwrk04.group5.iotbay.dao.UserDao;
import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.model.Order;
import isdwrk04.group5.iotbay.model.User;
import isdwrk04.group5.iotbay.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminController", value = "/admin")
public class AdminController extends BaseServlet {


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao orderDao = new OrderDao();
		List<Order> orders = orderDao.getAllOrders();
		request.setAttribute("orders" ,orders);

		UserDao userDao = new UserDao();
		List<User> users = userDao.getAllUsers();
		request.setAttribute("users", users);

		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getAllProducts();
		request.setAttribute("products", products);

		serveJSP(request, response, "admin.jsp");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		int orderId = Integer.parseInt(request.getParameter("orderId"));
		OrderDao orderDao = new OrderDao();
		Order order = orderDao.getOrderById(orderId);

		UserDao userDao = new UserDao();
		List<User> users = userDao.getAllUsers();
		request.setAttribute("users", users);

		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getAllProducts();
		request.setAttribute("products", products);

		redirectToUrl(request, response, "/admin");
	}
	

	/*
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");

        if (null == user || !user.getRole().equals(User.Role.Staff)) {
		session.setAttribute("errors", Collections.singletonList("You must be logged in as Admin to view this page."));
		serveJSP(request, response, "login.jsp");
	} else {
		serveJSP(request, response, "account.jsp");
        }
    }

    public void destroy() {
    }
    */
} 

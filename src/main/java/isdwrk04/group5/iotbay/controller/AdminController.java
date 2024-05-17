package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.OrderDao;
import isdwrk04.group5.iotbay.dao.UserDao;
import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.model.Order;
import isdwrk04.group5.iotbay.model.User;
import isdwrk04.group5.iotbay.model.Product;
// import isdwrk04.group5.iotbay.service.CSVParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "adminController", value = "/admin")
public class AdminController extends BaseServlet {


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (null == user || !user.getRole().equals(User.Role.Staff)) {
		    response.sendError(HttpServletResponse.SC_FORBIDDEN);
		    return;
		}

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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("file");
/*
         if (filePart != null) {
            InputStream fileContent = filePart.getInputStream();
            String fileName = filePart.getSubmittedFileName();

            // Determine the type of CSV based on the file name or an additional form field
            String fileType = request.getParameter("fileType");

            CSVParser csvParser = new CSVParser();
            switch (fileType) {
                case "orders":
                    List<Order> orders = csvParser.parseOrders(fileContent);
                    OrderDao orderDao = new OrderDao();
                    orderDao.bulkInsertOrUpdate(orders);
                    break;
                case "users":
                    List<User> users = csvParser.parseUsers(fileContent);
                    UserDao userDao = new UserDao();
                    userDao.bulkInsertOrUpdate(users);
                    break;
                case "products":
                    List<Product> products = csvParser.parseProducts(fileContent);
                    ProductDao productDao = new ProductDao();
                    productDao.bulkInsertOrUpdate(products);
                    break;
                default:
                    // Handle invalid file type
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid file type");
                    return;
            }
        }
 */

		redirectToUrl(request, response, "/admin");
	}
} 

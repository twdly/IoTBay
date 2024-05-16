<%@ page import="java.util.List" %>
<%@ page import="isdwrk04.group5.iotbay.model.Order" %>
<%@ page import="isdwrk04.group5.iotbay.model.User" %>
<%@ page import="isdwrk04.group5.iotbay.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% List<Order> orders = (List<Order>) request.getAttribute("orders"); %>
<% List<User> users = (List<User>) request.getAttribute("users"); %>
<% List<Product> products = (List<Product>) request.getAttribute("products"); %>
<html>
	<head>
		<title>IoTBay - Admin Panel</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">
	</head>
	<body>
		<main>
			<div class="container">
				<h2 class="heading">Orders</h2>
				<div class="table-container">
					<table id="orders-table">
						<tr>
							<th>Order ID</th>
							<th>Customer Name</th>
							<th>Phone Number</th>
							<th>Order Status</th>
							<th>Order Date</th>
							<th>Delivery Method</th>
						</tr>
						<% for (Order order : orders) { %>
							<tr>
								<td><%=order.getId()%></td>
								<td><%=order.getName()%></td>
								<td><%=order.getPhoneNo()%></td>
								<td><%=order.getStatus()%></td>
								<td><%=order.getOrderDate()%></td>
								<td><%=order.getMethod()%></td>
							</tr>
						<% } %>
					</table>
				</div>
			</div>

			<div class="container">
				<h2 class="heading">Users</h2>
				<div class="table-container">
					<table id="users-table">
						<tr>
							<th>User ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>User Role</th>
						</tr>
						<% for (User user : users) { %>
							<tr>
								<td><%=user.getId()%></td>
								<td><%=user.getUsername()%></td>
								<td><%=user.getEmail()%></td>
								<td><%=user.getRole()%></td>
							</tr>
						<% } %>
					</table>
				</div>
			</div>

			<div class="container">
				<h2 class="heading">Products</h2>
				<div class="table-container">
					<table id="product-table">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Image URL</th>
						</tr>
						<% for (Product product : products) { %>
							<tr>
								<td><%=product.getId()%></td>
								<td><%=product.getName()%></td>
								<td><%=product.getStock()%></td>
								<td><%=product.getPrice()%></td>
								<td><%=product.getImageUrl()%></td>
							</tr>
						<% } %>
					</table>
				</div>
			</div>
		</main>
	</body>
</html>

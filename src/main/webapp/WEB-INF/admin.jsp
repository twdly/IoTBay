<%@ page import="java.util.List" %>
<%@ page import="isdwrk04.group5.iotbay.model.Order" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% List<Order> orders = (List<Order>) request.getAttribute("orders"); %>
<% List<User> users = (List<User>) request.getAttribute("users"); %>
<html>
	<head>
		<title>IoTBay - Admin Panel</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">
	</head>
	<body>
		<main>
			<div class="container">
				<h2 class="heading">Orders</h2>
				<table id="orders-table">
					<tr>
						<th>Order ID</th>
						<th>Customer Name</th>
						<th>Delivery Method</th>
					</tr>
					<% for (Order order : orders) { %>
						<tr>
							<td><%=order.getId()%></td>
							<td><%=order.getName()%></td>
							<td><%=order.getMethod()%></td>
						</tr>
					<% } %>
				</table>
				<h2 class-"heading">Users</h2>
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
							<td><%=user.getUsername%></td>
							<td><%=user.getEmail()%></td>
							<td><%=user.getRole()%></td>
						</tr>
					<% } %>
				</table>
			</div>
		</main>
	</body>
</html>

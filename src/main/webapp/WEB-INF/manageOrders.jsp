<%@ page import="java.util.List" %>
<%@ page import="isdwrk04.group5.iotbay.model.Order" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% List<Order> orders = (List<Order>) request.getAttribute("orders"); %>
<%@ page import="isdwrk04.group5.iotbay.model.User" %>
<% User user = (User) request.getSession().getAttribute("user");%>
<html>
<head>
    <title>IoTBay - Manage Orders</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tables.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <a href="account"><button type="button" class="back-button">< Back</button></a>
    <div class="side-bar">
        <nav>
            <ul>
                <li><a href="account">Your Account</a></li>
                <li><a href="update-account">Update Account Details</a></li>
                <li><a href="orders">View Recent Orders</a></li>
                <% if (user.getRole().equals(User.Role.Staff)) { %>
                <li><a href="productCatalogue">Update Product Catalogue</a></li>
                <li><a href="manage-orders">Manage Orders</a></li>
                <% } %>
            </ul>
        </nav>
    </div>
    <div class="content">
    <h1 class="page-heading">Processing Orders:</h1>
    <form method="post" action="manage-orders">
    <table class="display-table">
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
                <td>
                    <button name="orderId" value="<%=order.getId()%>" type="submit" class="table-button">Mark Complete</button>
                </td>
            </tr>
        <% } %>
    </table>
    </form>
    </div>
</main>
</body>
</html>

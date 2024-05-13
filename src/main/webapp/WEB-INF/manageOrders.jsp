<%@ page import="java.util.List" %>
<%@ page import="isdwrk04.group5.iotbay.model.Order" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% List<Order> orders = (List<Order>) request.getAttribute("orders"); %>
<html>
<head>
    <title>IoTBay - Manage Orders</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tables.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <a href="account"><button type="button" class="back-button">< Back</button></a>
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
</main>
</body>
</html>

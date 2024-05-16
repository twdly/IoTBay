<%@ page import="isdwrk04.group5.iotbay.model.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="isdwrk04.group5.iotbay.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="isdwrk04.group5.iotbay.model.User" %>
<% User user = (User) request.getSession().getAttribute("user");%>
<!DOCTYPE html>
<html>
    <head>
        <title>IoTBay - Orders</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    </head>
    <body>
    <jsp:include page="header.jsp"/>
    <main>
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
            <% Order order = (Order) request.getAttribute("order");%>
            <h1>Order No. <%=order.getId()%></h1>
            <p>Order status: <%=order.getStatus()%></p>
            <h2>Products:</h2>
            <% for (Product product : (List<Product>) request.getAttribute("products")) { %>
            <p><%=product.getName()%> x<%=product.getQuantity()%> ($<%=product.calculatePrice()%>)</p>
            <% } request.removeAttribute("products"); request.removeAttribute("order");%>
            <% if (order.getStatus() == Order.Status.Processing) {%>
            <form action="view-order" method="post">
                <input type="hidden" name="type" value="cancel"/>
                <input type="hidden" name="number" value="<%=order.getId()%>"/>
                <button>Cancel</button>
            </form>
            <% } %>
            <a href="orders"><button type="button" class="back-button">< Back</button></a>
        </div>
    </main>
    </body>
</html>

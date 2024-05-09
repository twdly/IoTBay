<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="isdwrk04.group5.iotbay.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="isdwrk04.group5.iotbay.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home - IoTBay</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>

<body>
<header>
    <div class="logo">
        <a href="<%= request.getContextPath() %>/"><h1>IoTBay</h1></a>
    </div>

<%--    SELECT DISTINCT Product_Category FROM PRODUCT; --%>
<%--    SELECT * FROM PRODUCT WHERE Product_Category = --%>

    <form action="search" method="GET" >
        <div class="search-box">
            <label><input name="search" type="search" placeholder="Search IoT Products"></label>
            <button type="submit" class="search-button">
                <i class="fas fa-search"></i>
            </button>
        </div>
    </form>

    <div class="register-or-login">
        <% User user = (User) session.getAttribute("user");
            if (user != null) { %>
        Hello, <%= user.getUsername() %> | <a href="logout">Logout</a>
        <% } else { %>
        <a href="register">Register</a> | <a href="login">Login</a>
        <% } %>
    </div>

    <button class ="shopping-cart-button">
        <i class="fas fa-shopping-cart"></i>
        $9999.99
    </button>

</header>
<main>
    <div class="hero">
        <img src="${pageContext.request.contextPath}/images/hero-image-2.jpg" alt="Graphical representation of IoT">
        <div class="hero-text">
            <h1>Welcome to IoTBay</h1>
            <h2>The store for all your IoT needs!</h2>
        </div>
    </div>
    <div class="container">

        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            if (products != null && !products.isEmpty()) {
                Iterator<Product> iterator = products.iterator();
                while (iterator.hasNext()) {
                    Product product = iterator.next();
        %>
        <div class="product-card">
            <img class="product-image" src="${pageContext.request.contextPath}/images/digital-temperature-sensor.jpg" alt="A digital temperature sensor">
            <h3 class="product-name"><%=product.getName() %></h3>
            <p class="unit-price">$<%=product.getPrice() %></p>
            <button type="submit" name="add-to-cart" class="add-to-cart-button">Add to Cart</button>
        </div>
        <%
            }
        } else {
        %>
        <div class="product-card">
            <h3 class=product-name>No products available.</h3>
        </div>
        <% } %>

    </div>
</main>
</body>
</html>
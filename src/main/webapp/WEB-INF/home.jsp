<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<jsp:include page="/WEB-INF/header.jsp"/>
<main>
    <div class="hero">
        <img src="${pageContext.request.contextPath}/images/hero-image-3.jpg" alt="Graphical representation of IoT">
        <div class="hero-text">
            <h1>Welcome to IoTBay</h1>
            <h2>The store for all your IoT needs!</h2>
        </div>
    </div>

    <% Object query = request.getAttribute("searchQuery");
        Object category = request.getAttribute("category"); %>

    <% if (category != null) { %>
        <h3 id="breadcrumbs">
            <a href="<%= request.getContextPath() %>/">Home</a>
            >
            <%= (String)category %>
        </h3>
    <% } %>

    <h2 id="products-title">
        <% if (query != null) { %>
        Search Result: "<%= (String)query %>"
        <% } else if (category != null) { %>
        Category: <%= (String)category %>
        <% } else { %>
        Browse Our Products
        <% } %>
    </h2>


    <div class="container">

        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            if (products != null && !products.isEmpty()) {
                Iterator<Product> iterator = products.iterator();
                while (iterator.hasNext()) {
                    Product product = iterator.next();
        %>
        <div class="product-card">
            <img class="product-image" src="${pageContext.request.contextPath}/images/<%= product.getImageUrl() %>" alt="<%= product.getDescription()%>">
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
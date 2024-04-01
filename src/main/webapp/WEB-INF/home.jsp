<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="isdwrk04.group5.iotbay.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home - IoTBay</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
    </head>

    <body>
        <header>
            <div class="logo">
                <a href="<%=request.getRequestURI()%>"><h1>IoTBay</h1></a>
            </div>
            <div class="search-box">
                <label><input name="search" type="search" placeholder="Search IoT Products"></label>
            </div>
            <div class="register-or-login">
                <a href="register">Register</a> | <a href="login">Login</a>
            </div>
            <button class ="shopping-cart-button">$9999.99</button>
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
					<img class="product-image" src="${pageContext.request.contextPath}/images/digital-temperature-sensor.jpg" alt="A digital temperature sensor"</img>
					<h3 class="product-name"><%=product.getName() %></h3>
					<p class="unit-price"><%=product.getPrice() %></p>
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

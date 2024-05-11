<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="isdwrk04.group5.iotbay.model.User" %>
<%@ page import="isdwrk04.group5.iotbay.model.Cart" %>

<header>
    <div class="logo">
        <a href="<%= request.getContextPath() %>/"><h1>IoTBay</h1></a>
    </div>

    <div class="product-category-dropdown">
        <button class="dropdown-button">
            <i class="fa fa-bars"></i>
            <span>Product Categories</span>
        </button>
        <div class="dropdown-content">
            <%--@elvariable id="productCategories" type="java.util.List"--%>
            <c:forEach items="${productCategories}" var="category">
                <a href="${pageContext.request.contextPath}/search?category=${category}">${category}</a>
            </c:forEach>
        </div>
    </div>

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
        <a href="account">Hello, <%= user.getUsername()%></a> | <a href="logout">Logout</a>
        <% } else { %>
        <a href="register">Register</a> | <a href="login">Login</a>
        <% } %>
    </div>

    <button class ="shopping-cart-button">
        <i class="fas fa-shopping-cart"></i>
        <% Cart cart = (Cart) request.getSession().getAttribute("cart");%>
        <% if (cart == null) { %>
            $0.00
        <% } else { %>
            $<%=cart.getTotalPrice()%>
        <% } %>
    </button>

</header>
<%@ page import="isdwrk04.group5.iotbay.model.Order" %>
<%@ page import="isdwrk04.group5.iotbay.model.Cart" %>
<%@ page import="isdwrk04.group5.iotbay.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% Order order = (Order) request.getSession().getAttribute("currentOrder");
Cart cart = (Cart) request.getSession().getAttribute("cart");%>
<html>
<head>
    <title>IoTBay - Confirm Order</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<main class="text-display">
    <div class="content">
        <h1 class="form-element">Your Order</h1>
        <h2 class="form-element">Your details:</h2>
        <div class="form-container">
            <p class="form-element">Name: <%=order.getName()%></p>
            <p class="form-element">Phone number: <%=order.getPhoneNo()%></p>
            <p class="form-element">Method: <%=order.getMethod()%></p>
            <br>
            <h2>Display shipment and payment details here</h2>
            <br>
            <h2 class="form-element">Products:</h2>
            <% for (Product product : cart.getProducts()) {%>
                <p class="form-element"><%=product.getQuantity()%>x <%=product.getName()%> ($<%=product.calculatePrice()%>)</p>
            <% } %>
            <p class="form-element">Price: $<%=cart.getTotalPrice()%></p>
            <br>
            <form method="post" action="confirm-order">
                <button class="general-buttons btn-outline-dark button-gap">Confirm order</button>
            </form>
        </div>
    </div>
</main>
</body>
</html>

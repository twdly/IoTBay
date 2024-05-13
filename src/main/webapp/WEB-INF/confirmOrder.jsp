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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<main class="text-display">
    <h1>Your Order</h1>
    <h2>Your details:</h2>
    <p>Name: <%=order.getName()%></p>
    <p>Phone number: <%=order.getPhoneNo()%></p>
    <p>Method: <%=order.getMethod()%></p>
    <br>
    <h2>Display shipment and payment details here</h2>
    <br>
    <h2>Products:</h2>
    <% for (Product product : cart.getProducts()) {%>
        <p><%=product.getQuantity()%>x <%=product.getName()%> ($<%=product.calculatePrice()%>)</p>
    <% } %>
    <p>Price: $<%=cart.getTotalPrice()%></p>
    <br>
    <form method="post" action="confirm-order">
        <button>Confirm order</button>
    </form>
</main>
</body>
</html>

<%@ page import="isdwrk04.group5.iotbay.model.Order" %>
<%@ page import="isdwrk04.group5.iotbay.model.Cart" %>
<%@ page import="isdwrk04.group5.iotbay.model.Product" %>
<%@ page import="isdwrk04.group5.iotbay.model.PaymentDetails" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% Order order = (Order) request.getSession().getAttribute("currentOrder");
Cart cart = (Cart) request.getSession().getAttribute("cart");
PaymentDetails paymentDetails = (PaymentDetails) session.getAttribute("paymentDetails");
%>
<html>
<head>
    <title>IoTBay - Confirm Order</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Payment.css">
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
    <h2>Payment details:</h2>
    <c:if test = "${not empty PaymentDetails}">
        <p>Name on Card: <%= paymentDetails.getCardholder() %></p>
        <p>Card Number: <%= paymentDetails.getCardNumber() %></p>
        <p>CVV: <%= paymentDetails.getCvv() %></p>
        <p>Expiration Date: <%= paymentDetails.getExpirationDate() %></p>
        <a href="updatePayment.jsp" class="edit-icon"><i class="fas fa-edit"></i></a>
    </c:if>
    <c:if test = "${empty PaymentDetails}">
        <p> No payment details found. Please provide payment details.</p>
    </c:if>
    <br>
    <h2>Products:</h2>
    <% for (Product product : cart.getProducts()) {%>
        <p><%=product.getQuantity()%>x <%=product.getName()%> ($<%=product.calculatePrice()%>)</p>
    <% } %>
    <p>Price: $<%=cart.getTotalPrice()%></p>
    <br>
    <form method="post" action="confirmOrder">
        <button>Confirm order</button>
    </form>
</main>
</body>
</html>

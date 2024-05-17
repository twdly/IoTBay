<%@ page import="isdwrk04.group5.iotbay.model.User" %>
<%@ page import="isdwrk04.group5.iotbay.model.Order" %>
<%@ page import="isdwrk04.group5.iotbay.model.PaymentDetails" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    User user = (User) session.getAttribute("user");
    Order order = (Order) session.getAttribute("order");
    PaymentDetails paymentDetails = (PaymentDetails) session.getAttribute("paymentDetails");
%>
<html>
<head>
    <title>IoTBay - Make Payment</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tables.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Payment.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<main class="text-display">
    <h1>Payment Details</h1>
    <!-- Payment form -->
    <form class="payment-form" method="post" action="confirmOrder.jsp">
        <div class="form-group">
            <div class="payment-methods">
                <button><img src="${pageContext.request.contextPath}/images/mastercard-logo.png" alt="MasterCard"></button>
            </div>
        </div>
        <div class="form-group">
            <label for="name-on-card">Name on Card</label>
            <input type="text" id="name-on-card" name="nameOnCard" required>
        </div>
        <div class="form-group">
            <label for="card-number">Card Number</label>
            <input type="text" id="card-number" name="cardNumber" required>
        </div>
        <div class="form-group">
            <label for="cvv">CVV</label>
            <input type="text" id="cvv" name="cvv" required>
        </div>
        <div class="form-group">
            <label for="exp-date">Expiration Date</label>
            <input type="text" id="exp-date" name="expDate" required>
        </div>
        <button type="submit" class="submit-btn">MAKE A PAYMENT</button>
    </form>
</main>
</body>
</html>

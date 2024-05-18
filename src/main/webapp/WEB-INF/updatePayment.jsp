<%@ page import="isdwrk04.group5.iotbay.model.PaymentDetails" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
    PaymentDetails paymentDetails = (PaymentDetails) session.getAttribute("paymentDetails");
%>
<html>
<head>
    <title>IoTBay - Update Payment Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Payment.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<main class="text-display">
    <h1>Update Payment Details</h1>
    <form action="update-payment" method="post">
        <label for="nameOnCard">Name on Card:</label>
        <input type="text" id="nameOnCard" name="nameOnCard" value="<%= paymentDetails.getCardholder() %>"><br><br>

        <label for="cardNumber">Card Number:</label>
        <input type="text" id="cardNumber" name="cardNumber" value="<%= paymentDetails.getCardNumber() %>"><br><br>

        <label for="cvv">CVV:</label>
        <input type="text" id="cvv" name="cvv" value="<%= paymentDetails.getCvv() %>"><br><br>

        <label for="expDate">Expiration Date:</label>
        <input type="text" id="expDate" name="expDate" value="<%= paymentDetails.getExpirationDate() %>"><br><br>

        <label for="billingAddress">Billing Address:</label>
        <input type="text" id="billingAddress" name="billingAddress" value="<%= paymentDetails.getBillingAddress() %>"><br><br>

        <button type="submit">Update Payment Details</button>
    </form>
</main>
</body>
</html>

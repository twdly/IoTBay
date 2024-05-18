<%@ page import="isdwrk04.group5.iotbay.model.PaymentDetails" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>IoTBay - Payments</title>
    <script src="${pageContext.request.contextPath}/js/welcome.js" defer></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tables.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"/>
<a href="account"><button type="button" class="back-button">< Back</button></a>
<% List<PaymentDetails> payments = (List<PaymentDetails>) request.getAttribute("payments"); %>
<% if (payments == null || payments.isEmpty()) { %>
<h1>You have no payment details.</h1>
<% } else { %>
<h1 class="page-heading">Payment Details</h1>
<table class="display-table">
    <tr>
        <th>Payment ID</th>
        <th>Amount</th>
        <th>Method</th>
        <th>Cardholder</th>
        <th>Status</th>
    </tr>
    <% for (PaymentDetails payment : payments) { %>
    <tr>
        <td><%= payment.getId() %></td>
        <td><%= payment.getAmount() %></td>
        <td><%= payment.getMethod().name() %></td>
        <td><%= payment.getCardholder() %></td>
        <td><%= payment.getStatus().name() %></td>
    </tr>
    <% } %>
</table>
<% } %>
</body>
</html>

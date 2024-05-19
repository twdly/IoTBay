<%@ page import="isdwrk04.group5.iotbay.model.CollectionPoint" %>
<%@ page import="isdwrk04.group5.iotbay.model.DeliveryAddress" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Delete Shipment</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"/>
<main class="text-display">
    <h1>Delete Shipment</h1>
    <form method="post" action="delete-shipment">
        <label for="cpId">Collection Point ID:</label>
        <input type="text" id="cpId" name="cpId" required/>
        <br>
        <label for="daId">Delivery Address ID:</label>
        <input type="text" id="daId" name="daId" required/>
        <br>
        <button>Delete Shipment</button>
    </form>
</main>
</body>
</html>

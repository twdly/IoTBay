<%@ page import="isdwrk04.group5.iotbay.model.CollectionPoint" %>
<%@ page import="isdwrk04.group5.iotbay.model.DeliveryAddress" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update Shipment</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"/>
<main class="text-display">
    <h1>Update Shipment</h1>
    <form method="post" action="update-shipment">
        <label for="cpId">Collection Point ID:</label>
        <input type="text" id="cpId" name="cpId" required/>
        <br>
        <label for="cpName">Collection Point Name:</label>
        <input type="text" id="cpName" name="cpName" required/>
        <br>
        <label for="cpAddress">Collection Point Address:</label>
        <input type="text" id="cpAddress" name="cpAddress" required/>
        <br>
        <label for="cpCityId">Collection Point City ID:</label>
        <input type="text" id="cpCityId" name="cpCityId" required/>
        <br>
        <label for="daId">Delivery Address ID:</label>
        <input type="text" id="daId" name="daId" required/>
        <br>
        <label for="daAddress">Delivery Address:</label>
        <input type="text" id="daAddress" name="daAddress" required/>
        <br>
        <label for="daCityId">Delivery Address City ID:</label>
        <input type="text" id="daCityId" name="daCityId" required/>
        <br>
        <button>Update Shipment</button>
    </form>
</main>
</body>
</html>

<%@ page import="isdwrk04.group5.iotbay.model.CollectionPoint" %>
<%@ page import="isdwrk04.group5.iotbay.model.DeliveryAddress" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Shipment Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"/>
<main class="text-display">
    <h1>Shipment Details</h1>
    <h2>Collection Point</h2>
    <p>ID: <%= ((CollectionPoint) request.getAttribute("collectionPoint")).getId() %></p>
    <p>Name: <%= ((CollectionPoint) request.getAttribute("collectionPoint")).getName() %></p>
    <p>Address: <%= ((CollectionPoint) request.getAttribute("collectionPoint")).getAddress() %></p>
    <p>City ID: <%= ((CollectionPoint) request.getAttribute("collectionPoint")).getCityId() %></p>
    <h2>Delivery Address</h2>
    <p>ID: <%= ((DeliveryAddress) request.getAttribute("deliveryAddress")).getId() %></p>
    <p>Address: <%= ((DeliveryAddress) request.getAttribute("deliveryAddress")).getAddress() %></p>
    <p>City ID: <%= ((DeliveryAddress) request.getAttribute("deliveryAddress")).getCityId() %></p>
</main>
</body>
</html>

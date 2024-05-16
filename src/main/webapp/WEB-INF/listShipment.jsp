<%@ page import="isdwrk04.group5.iotbay.model.CollectionPoint" %>
<%@ page import="isdwrk04.group5.iotbay.model.DeliveryAddress" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>List Shipments</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"/>
<main class="text-display">
    <h1>List of Shipments</h1>
    <table>
        <thead>
        <tr>
            <th>Collection Point ID</th>
            <th>Collection Point Name</th>
            <th>Delivery Address ID</th>
            <th>Delivery Address</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<CollectionPoint> collectionPoints = (List<CollectionPoint>) request.getAttribute("collectionPoints");
            List<DeliveryAddress> deliveryAddresses = (List<DeliveryAddress>) request.getAttribute("deliveryAddresses");
            for (CollectionPoint cp : collectionPoints) {
                for (DeliveryAddress da : deliveryAddresses) {
        %>
        <tr>
            <td><%= cp.getId() %></td>
            <td><%= cp.getName() %></td>
            <td><%= da.getId() %></td>
            <td><%= da.getAddress() %></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</main>
</body>
</html>

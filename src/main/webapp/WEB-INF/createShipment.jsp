<%@ page import="isdwrk04.group5.iotbay.model.CollectionPoint" %>
<%@ page import="isdwrk04.group5.iotbay.model.DeliveryAddress" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create Shipment</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"/>
<main class="text-display">
    <form method="post" action="create-shipment">
        <h1>Create Shipment</h1>

        <label for="cpId">Collection Point:</label>
        <select id="cpId" name="cpId" required>
            <%
                List<CollectionPoint> collectionPoints = (List<CollectionPoint>) request.getAttribute("collectionPoints");
                if (collectionPoints != null && !collectionPoints.isEmpty()) {
                    for (CollectionPoint cp : collectionPoints) {
            %>
            <option value="<%= cp.getId() %>"><%= cp.getName() %></option>
            <%
                }
            } else {
            %>
            <option value="">No collection points available</option>
            <% } %>
        </select>
        <br>

        <label for="daId">Delivery Address:</label>
        <select id="daId" name="daId" required>
            <%
                List<DeliveryAddress> deliveryAddresses = (List<DeliveryAddress>) request.getAttribute("deliveryAddresses");
                if (deliveryAddresses != null && !deliveryAddresses.isEmpty()) {
                    for (DeliveryAddress da : deliveryAddresses) {
            %>
            <option value="<%= da.getId() %>"><%= da.getAddress() %></option>
            <%
                }
            } else {
            %>
            <option value="">No delivery addresses available</option>
            <% } %>
        </select>
        <br>

        <button>Create Shipment</button>
    </form>
</main>
</body>
</html>

<%@ page import="isdwrk04.group5.iotbay.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% User user = (User) session.getAttribute("user");%>
<html>
<head>
    <title>IoTBay - Place Order</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<main class="text-display">
    <% if (session.getAttribute("errors") != null) {
        List<String> errors = (List<String>)session.getAttribute("errors");
    %>
    <div id="sessionErrors" class="error">
        <% for (String error : errors) { %>
        <p style="color: red"><%=error%></p>
        <%}%>
    </div>
    <% session.removeAttribute("errors"); } %>
    <h1>Place Order</h1>
    <h2>Your details:</h2>
    <form method="post" action="payment">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" value="<%=user != null ? user.getUsername() : ""%>"/>
        <br>
        <label for="phone">Phone number:</label>
        <input type="text" name="phone" id="phone" value="<%=user != null ? user.getPhoneNo() : ""%>"/>
        <br>
        <label for="methods">Method:</label>
        <select id="methods" name="method">
            <option value="Delivery">Delivery</option>
            <option value="Collection">Collection</option>
        </select>
        <br>
        <button>Next ></button>
    </form>
</main>
</body>
</html>

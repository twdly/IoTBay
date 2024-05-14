<%@ page import="isdwrk04.group5.iotbay.model.User" %>
<% User user = (User)session.getAttribute("user"); %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>IoTBay - Update Account</title>
        <script src="${pageContext.request.contextPath}/js/welcome.js" defer></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
    </head>
    <body>
    <jsp:include page="header.jsp"/>
        <svg>
            <symbol id="icon-cart" viewBox="0 0 24 24" fill="none">
                <path d="M4.5 5H18.2768C19.0446 5 19.526 5.82948 19.1451 6.49614L16.5758 10.9923C16.2198 11.6154 15.5571 12 14.8394 12H8M8 12L6.45625 14.47C6.03997 15.136 6.51881 16 7.30425 16H18M8 12L4.05279 4.10557C3.714 3.428 3.02148 3 2.26393 3H2M8 20C8 20.5523 7.55228 21 7 21C6.44772 21 6 20.5523 6 20C6 19.4477 6.44772 19 7 19C7.55228 19 8 19.4477 8 20ZM18 20C18 20.5523 17.5523 21 17 21C16.4477 21 16 20.5523 16 20C16 19.4477 16.4477 19 17 19C17.5523 19 18 19.4477 18 20Z" stroke="currentColor" stroke-width="2" stroke-linecap="round"></path>
            </symbol>
        </svg>
        <a href="account" style="color: blue">< Back</a>
        <h2>Account details:</h2>
        <form id="accountForm" action="update-account" method="post">
            <input type="hidden" name="action" value="updateDetails">
            <div class="form-element">
                <label class="form-element" for="email">Email:</label>
                <input type="email" id="email" name="email" value=<%=user.getEmail()%>>
            </div>
            <div class="form-element">
                <label class="form-element" for="firstname">First name:</label>
                <input type="text" id="firstname" name="firstname" value=<%=user.getUsername().split(" ")[0]%>>
            </div>
            <div class="form-element">
                <label class="form-element" for="lastname">Last name:</label>
                <input type="text" id="lastname" name="lastname" value=<%=user.getUsername().split(" ")[1]%>>
            </div>
            <div class="form-element">
                <label class="form-element" for="phoneNumber">Phone number:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" value=<%=user.getPhoneNo()%>>
            </div>
            <button type="submit">Update details</button>
        </form>
        <form id="passwordForm">
            <input type="hidden" name="action" value="updatePassword">
            <h2>Change password:</h2>
            <div class="form-element">
                <label class="form-element" for="password">Password:</label>
                <input type="password" id="password" name="password">
            </div>
            <div class="form-element">
                <label class="form-element" for="passwordCheck">Re-enter password:</label>
                <input type="password" id="passwordCheck" name="passwordCheck">
            </div>
            <button type="submit">Change password</button>
        </form>
    </body>
</html>

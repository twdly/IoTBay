<%@ page import="isdwrk04.group5.iotbay.model.User" %>
<%@ page import="java.util.List" %>
<% User user = (User)session.getAttribute("user"); %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>IoTBay - Update Account</title>
        <script src="${pageContext.request.contextPath}/js/welcome.js" defer></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
    </head>
    <body>
    <jsp:include page="header.jsp"/>
    <svg>
        <symbol id="icon-cart" viewBox="0 0 24 24" fill="none">
            <path d="M4.5 5H18.2768C19.0446 5 19.526 5.82948 19.1451 6.49614L16.5758 10.9923C16.2198 11.6154 15.5571 12 14.8394 12H8M8 12L6.45625 14.47C6.03997 15.136 6.51881 16 7.30425 16H18M8 12L4.05279 4.10557C3.714 3.428 3.02148 3 2.26393 3H2M8 20C8 20.5523 7.55228 21 7 21C6.44772 21 6 20.5523 6 20C6 19.4477 6.44772 19 7 19C7.55228 19 8 19.4477 8 20ZM18 20C18 20.5523 17.5523 21 17 21C16.4477 21 16 20.5523 16 20C16 19.4477 16.4477 19 17 19C17.5523 19 18 19.4477 18 20Z" stroke="currentColor" stroke-width="2" stroke-linecap="round"></path>
        </symbol>
    </svg>
    <div class="side-bar">
        <nav>
            <ul>
                <li><a href="account">Your Account</a></li>
                <li><a href="update-account">Update Account Details</a></li>
                <li><a href="orders">View Recent Orders</a></li>
                <% if (user.getRole().equals(User.Role.Staff)) { %>--%>
                <li><a href="productCatalogue">Update Product Catalogue</a></li>
                <li><a href="manage-orders">Manage Orders</a></li>
                <% } %>
            </ul>
        </nav>
    </div>
    <div class="account-content">
        <div class="page-details">
            <div class="form-container">
                <div class="detail-form">
                    <h2>Account Details</h2>
                    <p id="errors" class="error"></p>
                    <% if (session.getAttribute("errors") != null) {
                        List<String> errors = (List<String>)session.getAttribute("errors");
                    %>
                    <%
                        boolean containsPassword = errors.stream().anyMatch(s -> s.contains("Password"));
                        if (!containsPassword) {
                    %>
                    <div id="sessionErrors" class="error">
                        <% for (String error : errors) { %>
                        <p><%=error%></p>
                        <% }
                        session.removeAttribute("errors");%>
                    </div>
                    <%
                        }

                    } %>
                    <form id="accountForm" action="update-account" method="post">
                        <input type="hidden" name="action" value="updateDetails">
                        <div class="form-element">
                            <label class="form-element" for="firstname">First name</label>
                            <input type="text" id="firstname" name="firstname" value=<%=user.getUsername().split(" ")[0]%>>
                        </div>
                        <div class="form-element">
                            <label class="form-element" for="lastname">Last name</label>
                            <input type="text" id="lastname" name="lastname" value=<%=user.getUsername().split(" ")[1]%>>
                        </div>
                        <div class="form-element">
                            <label class="form-element" for="email">Email</label>
                            <input type="email" id="email" name="email" value=<%=user.getEmail()%>>
                        </div>
                        <div class="form-element">
                            <label class="form-element" for="phoneNumber">Phone number</label>
                            <input type="text" id="phoneNumber" name="phoneNumber" value=<%=user.getPhoneNo()%>>
                        </div>
                        <button class="general-buttons" type="submit" onclick="updateDetails()">Update details</button>
                    </form>
                </div>
                <div class="password-form">
                    <h2>Change password</h2>
                    <p id="errors" class="error"></p>
                    <% if (session.getAttribute("errors") != null) {
                        List<String> errors = (List<String>)session.getAttribute("errors");
                    %>
                    <div id="sessionErrors" class="error">
                        <% for (String error : errors) { %>
                        <p><%=error%></p>
                        <% } %>
                    </div>
                    <%
                            session.removeAttribute("errors");
                        } %>
                    <form id="passwordForm" action="update-account" method="post">
                        <input type="hidden" name="action" value="updatePassword">
                        <div class="form-element">
                            <label class="form-element" for="password">Password</label>
                            <input type="password" id="password" name="password">
                        </div>
                        <div class="form-element">
                            <label class="form-element" for="passwordCheck">Re-enter password</label>
                            <input type="password" id="passwordCheck" name="passwordCheck">
                        </div>
                        <button class="general-buttons" type="submit" onclick="updatePassword()">Change password</button>
                    </form>
                </div>
            </div>
            <form id="deactivateForm" action="update-account" method="post">
                <input type="hidden" name="action" value="deactivate">
                <button class="general-buttons" type="submit" onclick="return confirm('Are you sure you want to deactivate your account?')">Deactivate Account</button>
            </form>
        </div>
    </div>
    </body>
</html>

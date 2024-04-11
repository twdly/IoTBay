<%--suppress unchecked --%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Register - IoTBay</title>
        <script src="${pageContext.request.contextPath}/js/register.js" defer></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    </head>

    <body>
        <div class="container">
            <h1>Register</h1>
            <p id="errors" class="error"></p>
            <% if (session.getAttribute("errors") != null) {
                List<String> errors = (List<String>)session.getAttribute("errors");
            %>
            <div id="sessionErrors" class="error">
                <% for (String error : errors) { %>
                <p><%=error%></p>
                <% } %>
            </div>
            <%session.removeAttribute("errors");
            } %>
            <form id="registerForm" action="register" method="post">
                <div class="form-element">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email">
            </div>
            <div class="form-element">
                <label for="firstname">First name:</label>
                <input type="text" id="firstname" name="firstname">
            </div>
            <div class="form-element">
                <label for="lastname">Last name:</label>
                <input type="text" id="lastname" name="lastname">
            </div>
            <div class="form-element">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password">
            </div>
            <div class="form-element">
                <label for="passwordCheck">Re-enter password:</label>
                <input type="password" id="passwordCheck" name="passwordCheck">
            </div>
        </form>
        <button onclick="register()">Register</button>
    </body>
</html>
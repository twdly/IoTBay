<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - IoTBay</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginpage.css">
</head>
<body>
    <header>
        <div class="back-to-home">
            <a href="${pageContext.request.contextPath}">Back to Home</a>
        </div>
    </header>
    <div class="login-container">
    <h1>Log in to your account</h1>
    <div class="login-form">
        <form method="post" action="login">
            <div class="input-container">
                <label for="email">Email: </label>
                <input type="text" id="email" name="email">
            </div>
            <div class="input-container">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password">
            </div>
            <div class="button-container">
                <button>Login</button>
            </div>
        </form>
    </div>

    <% if (session.getAttribute("errors") != null) {
        List<String> errors = (List<String>)session.getAttribute("errors");
    %>
    <div id="sessionErrors" class="error">
        <% for (String error : errors) { %>
        <p><%=error%></p>
        <%}%>
    </div>
    <% session.removeAttribute("errors"); } %>
</div>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Login - IoTBay</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    </head>
    <body>
        <h1>Log in to your account</h1>
        <br>
        <form method="post" action="login">
            <label for="email">Email: </label>
            <input type="text" id="email" name="email">
            <br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
            <br>

            <button>Log in</button>
            <% if (session.getAttribute("errors") != null) { List<String> errors = (List<String>)session.getAttribute("errors");%>
            <div id="sessionErrors" class="error">
                <% for (String error : errors) { %>
                <p><%=error%></p>
                <%}%>
            </div>
            <%session.removeAttribute("errors");}%>
        </form>
    </body>
</html>
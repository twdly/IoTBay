<%@ page import="isdwrk04.group5.iotbay.model.Customer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Welcome - IoTBay</title>
    </head>

    <body>
        <h1>Welcome, <%= ((Customer)session.getAttribute("user")).getUsername() %></h1>
        <p>You logged in with the password <%= ((Customer)session.getAttribute("user")).getPassword() %></p>
    </body>
</html>
<%@ page import="isdwrk04.group5.iotbay.model.Customer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% Customer customer = (Customer)session.getAttribute("user"); %>

<!DOCTYPE html>
<html>
    <head>
        <title>Welcome - IoTBay</title>
    </head>

    <body>
        <h1>Welcome, <%= customer.getUsername() %></h1>
        <p>You logged in with the password <%= customer.getHashedPassword() %></p>
    </body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login - IoTBay</title>
    </head>

    <body>
        <h1>Log in to your account</h1>
        <br>
        <form method="post" action="login">
            <label for="username">Username: </label>
            <input type="text" id="username" name="username">
            <br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
            <br>

            <button>Log in</button>
        </form>
    </body>
</html>
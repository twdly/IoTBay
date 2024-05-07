<%@ page import="isdwrk04.group5.iotbay.model.User" %>
<% User user = (User)session.getAttribute("user"); %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Account details:</h2>
<form id="accountForm" action="register" method="post">
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
</form>
<button>Update details</button>
<form id="passwordForm">
    <h2>Change password:</h2>
    <div class="form-element">
        <label class="form-element" for="password">Password:</label>
        <input type="password" id="password" name="password">
    </div>
    <div class="form-element">
        <label class="form-element" for="passwordCheck">Re-enter password:</label>
        <input type="password" id="passwordCheck" name="passwordCheck">
    </div>
</form>
<button>Change password</button>
<h2>Your orders:</h2>
<p>Past orders will be shown here</p>
</body>
</html>

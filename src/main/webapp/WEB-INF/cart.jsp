<%@ page import="isdwrk04.group5.iotbay.model.Product" %>
<%@ page import="isdwrk04.group5.iotbay.model.Cart" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% Cart cart = (Cart) request.getSession().getAttribute("cart");%>
<html>
<head>
    <title>IoTBay - Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<main class="text-display">
    <% if (cart == null || cart.isEmpty()) { %>
        <h1>Your cart is empty</h1>
        <p>Why not check out <a href="<%= request.getContextPath() %>">our store</a>?</p>
    <% }  else {%>
    <h1>Your cart</h1>
    <form method="post" action="cart">
    <table>
        <tr>
            <td>Item</td>
            <td>Quantity</td>
            <td>Stock</td>
            <td>Unit Price</td>
            <td>Total Price</td>
            <td>Manage</td>
        </tr>
        <% int itemNumber = 0;
            for (Product product : cart.getProducts()) { %>
            <tr>
                <td><%=product.getName()%></td>
                <td><input type="number" name="item<%=itemNumber%>" min="0" max="<%=product.getStock()%>" value="<%=product.getQuantity()%>"/></td>
                <td><%=product.getStock()%></td>
                <td>$<%=product.getPrice()%></td>
                <td>$<%=product.calculatePrice()%></td>
                <td><input type="submit" name="remove<%=itemNumber%>" value="Remove"/></td>
            </tr>
        <% itemNumber++; } %>
    </table>
    <br>
    <p>Total: $<%=cart.getTotalPrice()%></p>
    <br>
    <input type="submit" name="action" value="Save changes"/>
    <input type="submit" name="action" value="Place order"/>
    <input type="submit" name="action" value="Clear cart"/>
</form>
    <% } %>
</main>
</body>
</html>

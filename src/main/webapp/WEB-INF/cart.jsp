<%@ page import="isdwrk04.group5.iotbay.model.Product" %>
<%@ page import="isdwrk04.group5.iotbay.model.Cart" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% Cart cart = (Cart) request.getSession().getAttribute("cart");%>
<html>
<head>
    <title>IoTBay - Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tables.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<main class="text-display">
    <% if (cart == null || cart.isEmpty()) { %>
        <div id="empty-cart">
            <h1>Your cart is empty</h1>
            <p>Why not check out <a href="<%= request.getContextPath() %>">our store</a>?</p>
        </div>
    <% }  else {%>
    <h1 class="page-heading">Your cart</h1>
    <div id="cart">
        <form method="post" action="cart">
            <table class="display-table">
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Unit Price</th>
                    <th>Subtotal</th>
                </tr>
                <% int itemNumber = 0;
                    for (Product product : cart.getProducts()) { %>
                    <tr>
                        <td><%=product.getName()%></td>
                        <td><input type="number" name="item<%=itemNumber%>" min="0" max="<%=product.getStock()%>" value="<%=product.getQuantity()%>"/></td>
                        <td>$<%=product.getPrice()%></td>
                        <td>$<%=String.format("%.2f", product.calculatePrice())%></td>
                        <td><input type="submit" name="remove<%=itemNumber%>" value="Remove" class="table-button"/></td>
                    </tr>
                <% itemNumber++; } %>
            </table>
            <h2 id="total-price">Total: $<%=cart.getTotalPrice()%></h2>

            <div id="cart-buttons">
                <input type="submit" name="action" value="Clear cart" class="general-buttons btn-outline-light"/>
                <input type="submit" name="action" value="Save changes" class="general-buttons btn-outline-dark"/>
                <input type="submit" name="action" value="Place order" class="add-to-cart-button"/>
            </div>
        </form>
    </div>
    <% } %>
</main>
</body>
</html>

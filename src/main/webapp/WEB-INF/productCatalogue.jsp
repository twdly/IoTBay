<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="isdwrk04.group5.iotbay.model.Product" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Product Catalogue</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"/>
    <h1 id="product-catalogue-heading">Product Catalogue</h1>
    <table id="product-catalogue-table">
        <tr>
            <th>Product Name</th>
            <th>Product Category</th>
            <th>Description</th>
            <th>Price</th>
            <th>Stock</th>
        </tr>
        <% for (Product product : (List<Product>) request.getAttribute("products")) { %>
        <tr>
            <td><%=product.getName()%></td>
            <td><%=product.getCategory()%></td>
            <td><%=product.getDescription()%></td>
            <td><%=product.getPrice()%></td>
            <td><%=product.getStock()%></td>
            <td><button class="table-button">Update Product</button></td>
            <td><button class="table-button">Remove Product</button></td>
        </tr>
        <%}%>
    </table>

    <button class="add-product-button">Add New Product</button>
</body>
</html>

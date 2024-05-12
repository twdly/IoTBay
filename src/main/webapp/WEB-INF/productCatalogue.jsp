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

    <% if (session.getAttribute("errors") != null) {
        List<String> errors = (List<String>)session.getAttribute("errors");
    %>
    <div id="sessionErrors" class="error">
        <% for (String error : errors) { %>
        <p style="color: red"><%=error%></p>
        <%}%>
    </div>
    <% session.removeAttribute("errors"); } %>

    <button class="add-product-button" onclick="toggleForm()">Add New Product</button>
    <form id="add-new-product" action="productCatalogue" method="post">
        <h3 id="add-product-form-title">Enter Product Details Here</h3>
        <label for="product-name">Product Name<input type="text" name="product-name" id="product-name" placeholder="e.g. Smart Bin Sensor"></label>
        <label for="product-category">Product Category<input type="text" name="product-category" id="product-category" placeholder="e.g. Home Automation"></label>
        <label for="product-description">Description<input type="text" name="product-description" id="product-description" placeholder="e.g. A sensor for your bin"></label>
        <label for="product-price">Product Price<input type="text" name="product-price" id="product-price" placeholder="e.g. 100.00"></label>
        <label for="product-stock">Product Stock<input type="text" name="product-stock" id="product-stock" placeholder="e.g. 200"></label>
        <button id="submit-add-product-button" type="submit">Add Product</button>
    </form>

<script>
    function toggleForm() {
        const form = document.getElementById("add-new-product");
        form.style.display = form.style.display === "none" ? "flex" : "none";
        const button = document.querySelector(".add-product-button");
        button.style.display = button.style.display === "block" ? "none" : "block";
    }
</script>
</body>
</html>

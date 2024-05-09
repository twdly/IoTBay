<%@ page import="isdwrk04.group5.iotbay.model.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="isdwrk04.group5.iotbay.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>IoTBay - Orders</title>
        <script src="${pageContext.request.contextPath}/js/welcome.js" defer></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css">
    </head>
    <header>
        <nav>
            <div id="logo">
                IoTBay
            </div>
            <ul class="navigation-menu">
                <li>
                    <a href="${pageContext.request.contextPath}">Home</a>
                </li>
                <li>
                    <a href="#">Locations &amp; Hours</a>
                </li>
                <li>
                    <a href="store">Store</a>
                </li>
            </ul>
            <div id="utilities">
                <div class="search-container">
                    <form action="search">
                        <input id=search-bar type="text" placeholder="Search..." name="search">
                        <a href="#">
                            <svg class="search-icon" viewBox="0 0 800 800" fill="none">
                                <path d="M498.453 498.193L700 700M566.667 333.333C566.667 462.2 462.2 566.667 333.333 566.667C204.467 566.667 100 462.2 100 333.333C100 204.467 204.467 100 333.333 100C462.2 100 566.667 204.467 566.667 333.333Z" stroke="currentColor" stroke-width="66.6667" stroke-linecap="round"></path>
                            </svg>
                        </a>
                    </form>
                </div>
                <svg>
                    <use xlink:href="#icon-cart"></use>
                </svg>
                <a href="logout" class="logout-link">Logout</a>
            </div>
        </nav>
    </header>
    <body>
        <a href="orders" style="color: blue">< Back</a>
        <% Order order = (Order) request.getAttribute("order");%>
        <h1>Order No. <%=order.getId()%></h1>
        <p>Order status: <%=order.getStatus()%></p>
        <h2>Products:</h2>
        <% for (Product product : (List<Product>) request.getAttribute("products")) { %>
        <p><%=product.getName()%> x<%=product.getQuantity()%> ($<%=product.calculatePrice()%>)</p>
        <% } request.removeAttribute("products"); request.removeAttribute("order");%>
        <% if (order.getStatus() == Order.Status.Processing) {%>
        <form action="view-order" method="post">
            <input type="hidden" name="type" value="cancel"/>
            <input type="hidden" name="number" value="<%=order.getId()%>"/>
            <button>Cancel</button>
        </form>
        <% } %>
    </body>
</html>

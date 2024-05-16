<%@ page import="isdwrk04.group5.iotbay.model.User" %>
<%@ page import="isdwrk04.group5.iotbay.model.AccessLog" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% User user = (User) request.getSession().getAttribute("user");%>
<html>
    <head>
        <title>IoTBay - Account</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    </head>
    <body>
    <jsp:include page="header.jsp"/>
    <svg>
        <symbol id="icon-cart" viewBox="0 0 24 24" fill="none">
            <path d="M4.5 5H18.2768C19.0446 5 19.526 5.82948 19.1451 6.49614L16.5758 10.9923C16.2198 11.6154 15.5571 12 14.8394 12H8M8 12L6.45625 14.47C6.03997 15.136 6.51881 16 7.30425 16H18M8 12L4.05279 4.10557C3.714 3.428 3.02148 3 2.26393 3H2M8 20C8 20.5523 7.55228 21 7 21C6.44772 21 6 20.5523 6 20C6 19.4477 6.44772 19 7 19C7.55228 19 8 19.4477 8 20ZM18 20C18 20.5523 17.5523 21 17 21C16.4477 21 16 20.5523 16 20C16 19.4477 16.4477 19 17 19C17.5523 19 18 19.4477 18 20Z" stroke="currentColor" stroke-width="2" stroke-linecap="round"></path>
        </symbol>
        <symbol id="icon-profile" fill="#8c8f8d" viewBox="0 0 32 32">
            <path d="M8.0071,24.93A4.9958,4.9958,0,0,1,13,20h6a4.9959,4.9959,0,0,1,4.9929,4.93,11.94,11.94,0,0,1-15.9858,0ZM20.5,12.5A4.5,4.5,0,1,1,16,8,4.5,4.5,0,0,1,20.5,12.5Z" fill="#ffffff"/>
            <path d="M26.7489,24.93A13.9893,13.9893,0,1,0,2,16a13.899,13.899,0,0,0,3.2511,8.93l-.02.0166c.07.0845.15.1567.2222.2392.09.1036.1864.2.28.3008.28.3033.5674.5952.87.87.0915.0831.1864.1612.28.2417.32.2759.6484.5372.99.7813.0441.0312.0832.0693.1276.1006v-.0127a13.9011,13.9011,0,0,0,16,0V27.48c.0444-.0313.0835-.0694.1276-.1006.3412-.2441.67-.5054.99-.7813.0936-.08.1885-.1586.28-.2417.3025-.2749.59-.5668.87-.87.0933-.1006.1894-.1972.28-.3008.0719-.0825.1522-.1547.2222-.2392ZM16,8a4.5,4.5,0,1,1-4.5,4.5A4.5,4.5,0,0,1,16,8ZM8.0071,24.93A4.9957,4.9957,0,0,1,13,20h6a4.9958,4.9958,0,0,1,4.9929,4.93,11.94,11.94,0,0,1-15.9858,0Z"/>
        </symbol>
    </svg>
    <div class="side-bar">
        <nav>
            <ul>
                <li><a href="account">Your Account</a></li>
                <li><a href="update-account">Update Account Details</a></li>
                <li><a href="orders">View Recent Orders</a></li>
                <% if (user.getRole().equals(User.Role.Staff)) { %>
                <li><a href="productCatalogue">Update Product Catalogue</a></li>
                <li><a href="manage-orders">Manage Orders</a></li>
                <% } %>
            </ul>
        </nav>
    </div>
    <div class="account-content">
        <div class="user-profile">
            <svg id="icon-profile" fill="#8c8f8d" viewBox="0 0 32 32">
                <path d="M8.0071,24.93A4.9958,4.9958,0,0,1,13,20h6a4.9959,4.9959,0,0,1,4.9929,4.93,11.94,11.94,0,0,1-15.9858,0ZM20.5,12.5A4.5,4.5,0,1,1,16,8,4.5,4.5,0,0,1,20.5,12.5Z" fill="#ffffff"/>
                <path d="M26.7489,24.93A13.9893,13.9893,0,1,0,2,16a13.899,13.899,0,0,0,3.2511,8.93l-.02.0166c.07.0845.15.1567.2222.2392.09.1036.1864.2.28.3008.28.3033.5674.5952.87.87.0915.0831.1864.1612.28.2417.32.2759.6484.5372.99.7813.0441.0312.0832.0693.1276.1006v-.0127a13.9011,13.9011,0,0,0,16,0V27.48c.0444-.0313.0835-.0694.1276-.1006.3412-.2441.67-.5054.99-.7813.0936-.08.1885-.1586.28-.2417.3025-.2749.59-.5668.87-.87.0933-.1006.1894-.1972.28-.3008.0719-.0825.1522-.1547.2222-.2392ZM16,8a4.5,4.5,0,1,1-4.5,4.5A4.5,4.5,0,0,1,16,8ZM8.0071,24.93A4.9957,4.9957,0,0,1,13,20h6a4.9958,4.9958,0,0,1,4.9929,4.93,11.94,11.94,0,0,1-15.9858,0Z"/>
            </svg>
            <div class="user-details">
                <div class="user-name"><%= user.getUsername() %></div>
                <div class="user-email"><%= user.getEmail() %></div>
            </div>
        </div>
        <br>
        <div class="filter-by-date">
            <form id="filter-logs" action="account" method="post">
                <input id="date" name="date" type="date">
                <button class="filter-btn" type="submit">Filter/Clear</button>
            </form>
        </div>
        <div class="log-table">
            <table class="log-table">
                <thead>
                    <tr>
                        <th>User</th>
                        <th>Event</th>
                        <th>Event Date</th>
                        <th>Time</th>
                    </tr>
                </thead>
                <% if (request.getAttribute("userLogs") != null && request.getAttribute("userLogs") instanceof List) {
                    for (AccessLog log : (List<AccessLog>) request.getAttribute("userLogs")) {
                        LocalDateTime dateTime = log.getEventTime().toLocalDateTime();
                        String date = dateTime.toLocalDate().toString();
                        String time = dateTime.toLocalTime().toString();%>
                <tbody>
                    <tr>
                        <td><%=user.getUsername()%></td>
                        <td><%=log.getEvent()%></td>
                        <td><%=date%></td>
                        <td><%=time%></td>
                    </tr>
                </tbody>
                <%}
                }%>
            </table>
        </div>
    </div>
    </body>
</html>

<%@ page import="isdwrk04.group5.iotbay.model.Customer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% Customer customer = (Customer)session.getAttribute("user"); %>


<!DOCTYPE html>
<html>
<head>
    <title>Welcome - IoTBay</title>
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
            <svg>
                <use xlink:href="#icon-profile" onclick="toggleMenu()"></use>
            </svg>
        </div>
        <div class="profile-menu-wrap" id="profileMenu">
            <div class="profile-menu">
                <div class="user-info">
                    <h4><%= customer.getUsername() %></h4>
                </div>
                <hr>
                <a href="#" class="profile-menu-link">
                    <p>My Account</p>
                </a>
                <a href="#" class="profile-menu-link">
                    <p>Sign Out</p>
                </a>
            </div>
        </div>
    </nav>
</header>
<body>
<svg>
    <symbol id="icon-search" viewBox="0 0 800 800" fill="none">
        <path d="M498.453 498.193L700 700M566.667 333.333C566.667 462.2 462.2 566.667 333.333 566.667C204.467 566.667 100 462.2 100 333.333C100 204.467 204.467 100 333.333 100C462.2 100 566.667 204.467 566.667 333.333Z" stroke="currentColor" stroke-width="66.6667" stroke-linecap="round"></path>
    </symbol>
    <symbol id="icon-cart" viewBox="0 0 24 24" fill="none">
        <path d="M4.5 5H18.2768C19.0446 5 19.526 5.82948 19.1451 6.49614L16.5758 10.9923C16.2198 11.6154 15.5571 12 14.8394 12H8M8 12L6.45625 14.47C6.03997 15.136 6.51881 16 7.30425 16H18M8 12L4.05279 4.10557C3.714 3.428 3.02148 3 2.26393 3H2M8 20C8 20.5523 7.55228 21 7 21C6.44772 21 6 20.5523 6 20C6 19.4477 6.44772 19 7 19C7.55228 19 8 19.4477 8 20ZM18 20C18 20.5523 17.5523 21 17 21C16.4477 21 16 20.5523 16 20C16 19.4477 16.4477 19 17 19C17.5523 19 18 19.4477 18 20Z" stroke="currentColor" stroke-width="2" stroke-linecap="round"></path>
    </symbol>
    <symbol id="icon-profile" class="bad" viewBox="0 0 32 32" fill="currentColor">
        <path d="M16 16.75c4.28 0 7.75-3.47 7.75-7.75s-3.47-7.75-7.75-7.75c-4.28 0-7.75 3.47-7.75 7.75v0c0.005 4.278 3.472 7.745 7.75 7.75h0zM16 2.75c3.452 0 6.25 2.798 6.25 6.25s-2.798 6.25-6.25 6.25c-3.452 0-6.25-2.798-6.25-6.25v0c0.004-3.45 2.8-6.246 6.25-6.25h0zM30.41 29.84c-1.503-6.677-7.383-11.59-14.41-11.59s-12.907 4.913-14.391 11.491l-0.019 0.099c-0.011 0.048-0.017 0.103-0.017 0.16 0 0.414 0.336 0.75 0.75 0.75 0.357 0 0.656-0.25 0.731-0.585l0.001-0.005c1.351-5.998 6.633-10.41 12.945-10.41s11.594 4.413 12.929 10.322l0.017 0.089c0.076 0.34 0.374 0.59 0.732 0.59 0 0 0.001 0 0.001 0h-0c0.057-0 0.112-0.007 0.165-0.019l-0.005 0.001c0.34-0.076 0.59-0.375 0.59-0.733 0-0.057-0.006-0.112-0.018-0.165l0.001 0.005z"></path>
    </symbol>
    <symbol id="icon-settings" viewBox="0 0 20 20">
        <path d="M16.5833 10.55C16.4497 10.3979 16.3761 10.2024 16.3761 10C16.3761 9.79758 16.4497 9.60208 16.5833 9.45L17.65 8.25C17.7675 8.11889 17.8405 7.95392 17.8585 7.77876C17.8765 7.60359 17.8385 7.42724 17.75 7.275L16.0833 4.39167C15.9957 4.2396 15.8624 4.11907 15.7023 4.04724C15.5422 3.97541 15.3635 3.95597 15.1917 3.99167L13.625 4.30834C13.4256 4.34953 13.2181 4.31633 13.0416 4.215C12.865 4.11368 12.7317 3.95124 12.6667 3.75834L12.1583 2.23334C12.1024 2.06782 11.9959 1.92406 11.8539 1.82237C11.7118 1.72068 11.5414 1.66622 11.3667 1.66667H8.03333C7.85161 1.65718 7.67177 1.70744 7.5213 1.80976C7.37082 1.91209 7.25798 2.06085 7.19999 2.23334L6.73333 3.75834C6.66833 3.95124 6.53497 4.11368 6.35842 4.215C6.18187 4.31633 5.97434 4.34953 5.77499 4.30834L4.16666 3.99167C4.00379 3.96865 3.83774 3.99435 3.68945 4.06553C3.54116 4.13672 3.41725 4.25019 3.33333 4.39167L1.66666 7.275C1.57596 7.42554 1.53518 7.60091 1.55015 7.77602C1.56511 7.95114 1.63506 8.11704 1.74999 8.25L2.80833 9.45C2.94193 9.60208 3.01561 9.79758 3.01561 10C3.01561 10.2024 2.94193 10.3979 2.80833 10.55L1.74999 11.75C1.63506 11.883 1.56511 12.0489 1.55015 12.224C1.53518 12.3991 1.57596 12.5745 1.66666 12.725L3.33333 15.6083C3.42091 15.7604 3.55426 15.8809 3.71437 15.9528C3.87448 16.0246 4.05318 16.044 4.225 16.0083L5.79166 15.6917C5.99101 15.6505 6.19854 15.6837 6.37509 15.785C6.55164 15.8863 6.685 16.0488 6.74999 16.2417L7.25833 17.7667C7.31631 17.9392 7.42916 18.0879 7.57963 18.1902C7.73011 18.2926 7.90994 18.3428 8.09166 18.3333H11.425C11.5997 18.3338 11.7701 18.2793 11.9122 18.1776C12.0542 18.0759 12.1608 17.9322 12.2167 17.7667L12.725 16.2417C12.79 16.0488 12.9234 15.8863 13.0999 15.785C13.2764 15.6837 13.484 15.6505 13.6833 15.6917L15.25 16.0083C15.4218 16.044 15.6005 16.0246 15.7606 15.9528C15.9207 15.8809 16.0541 15.7604 16.1417 15.6083L17.8083 12.725C17.8968 12.5728 17.9348 12.3964 17.9168 12.2212C17.8989 12.0461 17.8259 11.8811 17.7083 11.75L16.5833 10.55ZM15.3417 11.6667L16.0083 12.4167L14.9417 14.2667L13.9583 14.0667C13.3581 13.944 12.7338 14.0459 12.2038 14.3532C11.6738 14.6604 11.2751 15.1515 11.0833 15.7333L10.7667 16.6667H8.63333L8.33333 15.7167C8.14154 15.1349 7.74281 14.6437 7.21283 14.3365C6.68285 14.0293 6.05851 13.9273 5.45833 14.05L4.47499 14.25L3.39166 12.4083L4.05833 11.6583C4.46829 11.2 4.69494 10.6066 4.69494 9.99167C4.69494 9.37672 4.46829 8.78335 4.05833 8.325L3.39166 7.575L4.45833 5.74167L5.44166 5.94167C6.04185 6.06435 6.66618 5.9624 7.19617 5.65517C7.72615 5.34793 8.12487 4.8568 8.31666 4.275L8.63333 3.33334H10.7667L11.0833 4.28333C11.2751 4.86513 11.6738 5.35627 12.2038 5.6635C12.7338 5.97074 13.3581 6.07269 13.9583 5.95L14.9417 5.75L16.0083 7.6L15.3417 8.35C14.9363 8.8073 14.7125 9.39724 14.7125 10.0083C14.7125 10.6194 14.9363 11.2094 15.3417 11.6667V11.6667ZM9.69999 6.66667C9.04072 6.66667 8.39626 6.86217 7.84809 7.22844C7.29993 7.59471 6.87269 8.1153 6.6204 8.72439C6.3681 9.33348 6.30209 10.0037 6.43071 10.6503C6.55933 11.2969 6.8768 11.8908 7.34297 12.357C7.80915 12.8232 8.40309 13.1407 9.04969 13.2693C9.6963 13.3979 10.3665 13.3319 10.9756 13.0796C11.5847 12.8273 12.1053 12.4001 12.4716 11.8519C12.8378 11.3037 13.0333 10.6593 13.0333 10C13.0333 9.11595 12.6821 8.2681 12.057 7.64298C11.4319 7.01786 10.584 6.66667 9.69999 6.66667V6.66667ZM9.69999 11.6667C9.37036 11.6667 9.04813 11.5689 8.77404 11.3858C8.49996 11.2026 8.28634 10.9424 8.1602 10.6378C8.03405 10.3333 8.00104 9.99815 8.06535 9.67485C8.12966 9.35155 8.2884 9.05458 8.52148 8.82149C8.75457 8.5884 9.05154 8.42967 9.37484 8.36536C9.69815 8.30105 10.0333 8.33406 10.3378 8.4602C10.6423 8.58635 10.9026 8.79997 11.0858 9.07405C11.2689 9.34813 11.3667 9.67037 11.3667 10C11.3667 10.442 11.1911 10.866 10.8785 11.1785C10.5659 11.4911 10.142 11.6667 9.69999 11.6667Z"></path>
    </symbol>
    <symbol id="icon-logout" viewBox="0 0 24 24" fill="currentColor">
        <path d="M21 12L13 12" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
        <path d="M18 15L20.913 12.087V12.087C20.961 12.039 20.961 11.961 20.913 11.913V11.913L18 9" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
        <path d="M16 5V4.5V4.5C16 3.67157 15.3284 3 14.5 3H5C3.89543 3 3 3.89543 3 5V19C3 20.1046 3.89543 21 5 21H14.5C15.3284 21 16 20.3284 16 19.5V19.5V19" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
    </symbol>
</svg>
<%--<%--%>
<%--    if (request.getParameter("logout") != null && request.getParameter("logout").equals("true")) {--%>
<%--        session.invalidate();--%>
<%--    }--%>
<%--    if (request.getSession(false) == null) {--%>
<%--    //    response.sendRedirect(request.getContextPath());--%>
<%--} else {--%>
<%--%>--%>
<section class="welcome">
    <h1>Welcome <%= customer.getUsername() %></h1>
    <h2>Your email is <%= customer.getEmail() %></h2>
    <%--            <p>You logged in with the password <%= customer.getHashedPassword() %> (If this doesn't look like gibberish, I've done something wrong)</p>--%>
    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/store">
            <button type="button" class="btn-outline-dark">
                Shop All Products
                <svg id="welcome-icon-product" viewBox="0 0 24 24" fill="none">
                    <path d="M4.5 5H18.2768C19.0446 5 19.526 5.82948 19.1451 6.49614L16.5758 10.9923C16.2198 11.6154 15.5571 12 14.8394 12H8M8 12L6.45625 14.47C6.03997 15.136 6.51881 16 7.30425 16H18M8 12L4.05279 4.10557C3.714 3.428 3.02148 3 2.26393 3H2M8 20C8 20.5523 7.55228 21 7 21C6.44772 21 6 20.5523 6 20C6 19.4477 6.44772 19 7 19C7.55228 19 8 19.4477 8 20ZM18 20C18 20.5523 17.5523 21 17 21C16.4477 21 16 20.5523 16 20C16 19.4477 16.4477 19 17 19C17.5523 19 18 19.4477 18 20Z" stroke="currentColor" stroke-width="2" stroke-linecap="round"></path>
                </svg>
            </button>
        </a>
<%--        trying to add the logout button but confused how i can get the button to invalidate the session and redirect the user--%>
        <form action="" method="post">
            <input type="hidden" name="logout" value="true">
                <button type="submit" class="btn-outline-light">
                    Not Your Account?
                    <svg id="welcome-icon-logout" viewBox="0 0 24 24" fill="none">
                        <path d="M21 12L13 12" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
                        <path d="M18 15L20.913 12.087V12.087C20.961 12.039 20.961 11.961 20.913 11.913V11.913L18 9" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
                        <path d="M16 5V4.5V4.5C16 3.67157 15.3284 3 14.5 3H5C3.89543 3 3 3.89543 3 5V19C3 20.1046 3.89543 21 5 21H14.5C15.3284 21 16 20.3284 16 19.5V19.5V19" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
                    </svg>
                </button>
        </form>
    </div>
</section>
<%--<%--%>
<%--    }--%>
<%--%>--%>
</body>
</html>


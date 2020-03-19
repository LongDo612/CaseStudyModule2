<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: longdo
  Date: 19/03/2020
  Time: 2:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="CSS/style1.css">
</head>
<body>
<div class="nav-section">
    <nav>
        <div class="logo">
            <h4>Travel Ahead</h4>
        </div>
        <ul class="nav-links">
            <li><a href="#">Home</a></li>
            <li><a href="#">Travel</a></li>
            <li><a href="#">Login</a></li>
            <li><a href="#">Sign Up</a></li>
            <li><a href="#">About Us</a></li>
        </ul>
    </nav>
    <%
        String username = request.getParameter("username");
        Date loginTime = (Date) request.getAttribute("loginTime");
    %>


</div>
<h1 class="welcome">Welcome back <%=username%>! Successful login at <%=loginTime%></h1>

<div class="member-manage">
    <p>
        <a href="login.jsp">Log Out</a>
    </p>
    
    <p><a href="/login?action=edit">Edit your profile</a></p>
</div>
</body>
</html>

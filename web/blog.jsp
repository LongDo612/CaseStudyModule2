<%--
  Created by IntelliJ IDEA.
  User: longdo
  Date: 20/03/2020
  Time: 8:52 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Your Blog Site</h2>

    <h3><a href="/login?action=add">Add new blog</a></h3>

    <table>
        <tr>
            <td>Blog</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>

        <c:forEach items='${requestScope["blogs"]}' var="blog">
            <tr>
                <td>${blog.getHeader()}<br> ${blog.getContent()}<br> ${blog.getImage()}</td>
                <td><a href="/login?action=edit&id=${blog.id}">Edit</a></td>
                <td><a href="/login?action=delete&id=${blog.id}">Delete</a></td>
            </tr>
            <tr></tr>
            <tr></tr>
        </c:forEach>
    </table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: longdo
  Date: 20/03/2020
  Time: 11:06 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Delete Blog</h3>

    <p><a href="blog.jsp">Back to your blog site</a></p>

    <form method="post">
        <h3>You want to delete ${requestScope["blog"].getHeader()} ?</h3>
        <table>
            <tr>
                <td>Title</td>
                <td>${requestScope["blog"].getHeader()}</td>
            </tr>

            <tr>
                <td>Content</td>
                <td>${requestScope["blog"].getContent()}</td>
            </tr>

            <tr>
                <td>Image</td>
                <td>${requestScope["blog"].getImage()}</td>
            </tr>

            <tr><input type="submit" value="Delete Blog"></tr>
        </table>
    </form>
</body>
</html>

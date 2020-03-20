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
<form method="post">
    <h2>
        Add a new blog
    </h2>

    <table>
        <tr>
            <td>Header</td>
            <td><input type="text" name="NewHeader"></td>
        </tr>

        <tr>
            <td>Content</td>
            <td><input type="text" name="NewContent"></td>
        </tr>

        <tr>
            <td>Image</td>
            <td><input type="text" name="NewImage"></td>
        </tr>

        <tr><input type="submit" value="Add Blog"></tr>
    </table>

    <h3><a href="blog.jsp">Return to your blog site</a></h3>
</form>
</body>
</html>

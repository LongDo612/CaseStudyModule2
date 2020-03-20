<%--
  Created by IntelliJ IDEA.
  User: longdo
  Date: 20/03/2020
  Time: 10:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post">
        <table>
            <tr>
                <td>New Tittle</td>
                <td><input type="text" name="newTitle" value="${requestScope["blog"].getHeader()}"></td>
            </tr>

            <tr>
                <td>New Content</td>
                <td><input type="text" name="newContent1" value="${requestScope["blog"].getContent()}"></td>
            </tr>

            <tr>
                <input type="submit" value="Update Blog">
                <h3><a href="/login">Return to your blog site</a></h3>
            </tr>
        </table>
    </form>
</body>
</html>

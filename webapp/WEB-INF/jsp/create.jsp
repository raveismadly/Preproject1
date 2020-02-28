<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>

<%--<div align="center">--%>
<%--    <a href="read">Read</a>--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <caption>--%>
<%--            Create--%>
<%--        </caption>--%>
<%--        <form method="POST">--%>
<%--            <tr>--%>
<%--                <th>Name</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="name" size="45"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Surname</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="surname" size="45"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Age</th>--%>
<%--                <td>--%>
<%--                    <input type="number" name="age" size="45"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td colspan="2" align="center">--%>
<%--                    <input type="submit" value="Submit">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </form>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<form method="post">
<a href="read">Read</a>
    <table>
        <tr>
            <th>
                Name
            </th>
            <td><input name="name" type="text">
            </td>
        </tr>
        <tr>
            <th>Surname</th>
            <td>
                <input name="surname" type="text">
            </td>
        </tr>
        <tr>
            <th>Age</th>
            <td>
                <input name="age" type="number">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

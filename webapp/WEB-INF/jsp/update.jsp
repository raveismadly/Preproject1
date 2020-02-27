<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

<%--<div align="center">--%>
<%--    <a href="create">Create</a>--%>
<%--    &nbsp;&nbsp;&nbsp;--%>
<%--    <a href="read">Read</a>--%>
<%--    <jsp:useBean id="haveThisUser" scope="request" type="User.User"/>--%>
<%--    <c:if test="${haveThisUser != null}">--%>
<%--    <form action="update" method="POST">--%>
<%--        </c:if>--%>
<%--        <table border="1" cellpadding="5">--%>
<%--            <caption>--%>
<%--                Update--%>
<%--            </caption>--%>
<%--            <c:if test="${haveThisUser != null}">--%>
<%--                <input type="hidden" name="id" value="<c:out value='${haveThisUser.id}' />"/>--%>
<%--            </c:if>--%>
<%--            <tr>--%>
<%--                <th>Name</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="name" size="45"--%>
<%--                           value="<c:out value='${haveThisUser.name}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Surname</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="surname" size="45"--%>
<%--                           value="<c:out value='${haveThisUser.surname}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Age</th>--%>
<%--                <td>--%>
<%--                    <input type="number" name="age" size="45"--%>
<%--                           value="<c:out value='${haveThisUser.age}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td colspan="2" align="center">--%>
<%--                    <input type="submit" value="Save"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>
<%--</div>--%>
<a href="create">Create</a>
<a href="read">Read</a>
<jsp:useBean id="haveThisUser" scope="request" type="User.User"/>
    <c:if test="${haveThisUser!=null}">
        <form action="update" METHOD="post">
    </c:if>
        <table>
            <c:if test="${haveThisUser!=null}">
                <input type="hidden" name="id" value="<c:out value='${haveThisUser.id}'/>"/>
            </c:if>
            <tr><th>Name</th>
                <td><input name="name" type="text" value="<c:out value='${haveThisUser.name}'/>"/></td>

                <th>Surname</th>
                <td><input name="surname" type="text" value="<c:out value='${haveThisUser.surname}'/>"/></td>
            <th>Age</th>
                <td><input name="age" type="number"value="<c:out value='${haveThisUser.age}'/>"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
        </form>

</body>
</html>

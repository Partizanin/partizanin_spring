<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Partizanin
  Date: 20.09.2014
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all admins</title>

</head>
<body>

<form action="/Editable" method="post">
    <div align="center">
        <h1 align="center">Employee List</h1>
        <table align="center" border="1">

            <tr>
                <th>ADMIN_ID</th>
                <th>ADMIN_LOGIN</th>
                <th>ADMIN_INVITOR</th>
                <th>ADMIN_PASS</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="admin" items="${adminList}">
                <tr>
                    <td><c:out value="${admin.getId()}"/></td>
                    <td><c:out value="${admin.getLogin()}"/></td>
                    <td><c:out value="${admin.getLoginAnotherAdmin()}"/></td>
                    <td><c:out value="${admin.getPassword()}"/></td>

                    <td><a href="editEmployee.htm?id=${id}&action=EDIT
                    &login=${admin.getLogin()}&
                    invitor=${admin.getLoginAnotherAdmin()}&
                    pass=${admin.getPassword()}">Edit</a></td>
                    <td><a href="deleteEmployee.htm?id=${id}&action=DELETE">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>

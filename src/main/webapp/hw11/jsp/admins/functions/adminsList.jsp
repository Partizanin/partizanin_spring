<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link rel="stylesheet" href="/hw11/css/Tables.css" type="text/css"/>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/ico">

</head>
<body>

<%
    String messeg = "";
    if (request.getAttribute("message") != null) {
        messeg = (String) request.getAttribute("message");
    }
%>

<form class="form-container" action="/AdminTable" method="post">
    <table table border="1" width="50%" style="margin-bottom: 10px" class="rounded_edges" align="center">
        <div class="form-title"><h2 style="font-size: 40px">Admins list</h2></div>
        <div>
            <th style="color: #ffa600">ADMIN_ID</th>
            <th style="color: #ffa600">ADMIN_LOGIN</th>
            <th style="color: #ffa600">ADMIN_INVITOR</th>
            <th style="color: #ffa600">ADMIN_PASS</th>
        </div>
        <tr></tr>
        <c:forEach var="admin" items="${adminList}">
            <div>
                <tr>
                    <td style="color:#8fff3a">${admin.getId()}</td>
                    <td style="color: #a55fff">${admin.getLogin()}</td>
                    <td style="color: #ff232d">${admin.getLoginAnotherAdmin()}</td>
                    <td style="color: #4dffcf">${admin.getPassword()}</td>
                </tr>
            </div>
        </c:forEach>
        <div>
            <td><label>
                <input style="color: #8fff3a; width: 100%; " type="text" name="adminId" value="${admin.getId()}"/>
            </label></td>
            <td><label>
                <input style="color: #a55fff;width: 100%" type="text" name="adminLogin" value="${admin.getLogin()}"/>
            </label></td>
            <td><label>
                <input style=" color: #ff232d; width: 100%" type="text" name="adminInvitor"
                       value="${admin.getLoginAnotherAdmin()}"/>
            </label></td>
            <td><label>
                <input style="color: #4dffcf; width: 100%" type="text" name="adminPass" value="${admin.getPassword()}"/>
            </label></td>
            <tr></tr>
        </div>
        <div class="submit-container">
            <td><input class="submit-button" style="width: 100%" type="submit" name="action" value="Add"/></td>
            <td><input class="submit-button" style="width: 100%" type="submit" name="action" value="Edit"/></td>
            <td><input class="submit-button" style="width: 100%" type="submit" name="action" value="Delete"/></td>
            <td><input class="submit-button" style="width: 100%" type="submit" name="action" value="Search"/></td>
            <tr></tr>
            <td colspan="4"><input class="submit-button" style="width: 100%;height: 50px" type="submit" name="action"
                                   value="Return"/></td>
        </div>
    </table>
    <h2 style="color: #ff0000; font-size: 15px;margin-left:10px;margin-bottom:10px"><%=messeg%>
    </h2>
    <%request.removeAttribute("message");%>
    <%--<a href="goToServlet?param1=value1&param2=value2">Go to servlet</a>--%>
    <%--goToServlet?param1=value1&param2=value2--%>

    <%--<a href="meteridinfosuper.jsp?mid=<%=rs.getInt("meterid")%>&cid=<%=rs.getInt("consumerid")%>&cname=<%=rs.getInt("consumername")%>">
        <%=rs.getInt("Meterid")%>
    </a>--%>


    <%--<tr>
        <td><input type="submit" name="Submit" value="Update" style="background-color:#49743D;font-weight:bold;color:#ffffff;"></td>
    </tr>--%>


    <%-- <tr>
    <th>ADMIN_ID</th>
    <th>ADMIN_LOGIN</th>
        <th>ADMIN_INVITOR</th>
        <th >ADMIN_PASS</th>
    </tr>
    <tr>
    <c:forEach var="row"  items="${adminList}">
        <td><input type="text" readonly name="ADMIN_ID" value="${row.getId()}"></td>
        <td><input type="text" name="ADMIN_LOGIN" value="${row.getLogin()}"></td>
        <td><input type="text" name="ADMIN_INVITOR" value="${row.getLoginAnotherAdmin()}"></td>
        <td><input type="text" name="ADMIN_PASS" value="${row.getPassword()}"></td>
        <td><input type="submit" name="SubmitUpdate" value="Update" style="background-color:#028af9;font-weight:bold;color:#ffffff;"/>
            <input type="submit" name="SubmitDelete" value="Delete" style="background-color:#ff0703;font-weight:bold;color:#ffffff;"></td>
    </tr>
    </c:forEach>--%>

</form>
</body>
</html>

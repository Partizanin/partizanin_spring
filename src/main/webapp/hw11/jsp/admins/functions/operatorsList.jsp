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
    <title>Show all operators</title>
    <link rel="stylesheet" href="/hw11/css/TablesOperator.css" type="text/css"/>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/ico">

</head>
<body>

<%
    String messeg = "";
    if (request.getAttribute("message") != null) {
        messeg = (String) request.getAttribute("message");
    }
%>
<form class="form-container" action="/OperatorTable" method="post">
    <table border="1" width="50%" class="rounded_edges" align="center">
        <div class="form-title"><h2 style="font-size: 40px">Operator list</h2></div>
        <div>
            <th style="color: #ffa600">operator_id</th>
            <th style="color: #ffa600">operator_login</th>
            <th style="color: #ffa600">operator_password</th>
            <th style="color: #ffa600">operator_identifyNumber</th>
            <th style="color: #ffa600">operator_invitor</th>
        </div>
        <tr></tr>
        <c:forEach var="operator" items="${operatorList}">
            <div>
                <tr>
                    <td style="color:#8fff3a ">${operator.getId()}</td>
                    <td style="color: #a55fff">${operator.getLogin()}</td>
                    <td style="color: #ff232d">${operator.getPassword()}</td>
                    <td style="color: #4dffcf">${operator.getIdentifyNumber()}</td>
                    <td style="color: #0e00ff">${operator.getLoginAnotherOperator()}</td>
                </tr>
            </div>
        </c:forEach>
        <div>
            <td><label>
                <input style=" color: #8fff3a; width: 100%" type="text" name="operatorID" value="${operator.getId()}"/>
            </label></td>
            <td><label>
                <input style="color: #a55fff; width: 100%" type="text" name="operatorLogin"
                       value="${operator.getLogin()}"/>
            </label></td>
            <td><label>
                <input style=" color: #ff232d;width: 100%" type="text" name="operatorPass"
                       value="${operator.getPassword()}"/>
            </label></td>
            <td><label>
                <input style=" color: #4dffcf;width: 100%" type="text" name="operatorIDN"
                       value="${operator.getIdentifyNumber()}"/>
            </label></td>
            <td><label>
                <input style=" color: #0e00ff;width: 100%" type="text" name="operatorAnotherLogin"
                       value="${operator.getLoginAnotherOperator()}"/>
            </label></td>
            <tr></tr>
        </div>
        <div class="submit-container">
            <td><input class="submit-button" style="width: 100%" type="submit" name="action" value="Add"/></td>
            <td><input class="submit-button" style="width: 100%" type="submit" name="action" value="Edit"/></td>
            <td><input class="submit-button" style="width: 100%" type="submit" name="action" value="Delete"/></td>
            <td colspan="2"><input class="submit-button" style="width: 100%" type="submit" name="action"
                                   value="Search"/></td>
            <tr></tr>
            <td colspan="5"><input class="submit-button" style="width: 100%;height: 50px" type="submit" name="action"
                                   value="Return"/></td>
        </div>
    </table>
    <h2 style="color: #ff0000; font-size: 15px;margin-left:10px;margin-bottom:10px"><%=messeg%>
    </h2>
    <%request.removeAttribute("message");%>


</form>
</body>
</html>

<jsp:useBean id="client" scope="request" type="hw11.model.domain.Client"/>
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
    <title>Show all clients</title>
    <link rel="stylesheet" href="<c:url value="/hw11/css/TablesClient.css"/>" type="text/css"/>
    <link rel="shortcut icon" href="<c:url value="/images/favicon.ico"/>" type="image/ico">

</head>
<body>
<%
    String messeg = "";
    if (request.getAttribute("message") != null) {
        messeg = (String) request.getAttribute("message");
    }
%>
<form class="form-container" action="<c:url value="/ClientTable"/>" method="post">
    <table border="1" width="50%" class="rounded_edges" align="center">
        <div class="form-title"><h2 style="font-size: 40px">Client list</h2></div>
        <div>
            <th style="color: #ffa600">client_id</th>
            <th style="color: #ffa600">client_name</th>
            <th style="color: #ffa600">client_surname</th>
            <th style="color: #ffa600">client_phoneNumber</th>
            <th style="color: #ffa600">client_address</th>
            <th style="color: #ffa600">client_summa</th>
            <th style="color: #ffa600">client_lastDate</th>
        </div>
        <tr></tr>
        <jsp:useBean id="clientList" scope="request" type="java.util.List"/>
        <c:forEach var="client" items="${clientList}">
            <div>
                <tr>
                    <td style="color:#8fff3a">${client.getId()}</td>
                    <td style="color:#a55fff">${client.getName()}</td>
                    <td style="color:#ff232d">${client.getSurname()}</td>
                    <td style="color:#4dffcf">${client.getPhoneNumber()}</td>
                    <td style="color:#0e00ff">${client.getAddress()}</td>
                    <td style="color:#ff6600">${client.getSumma()}</td>
                    <td style="color:#ff007d">${client.getLastDate()}</td>
                </tr>
            </div>
        </c:forEach>
        <div>
            <td><label>
                <input style=" color:#8fff3a; width: 100%" type="text" name="clientnId" value="${client.getId()}"/>
            </label></td>
            <td><label>
                <input style=" color:#a55fff; width: 100%" type="text" name="clientName" value="${client.getName()}"/>
            </label></td>
            <td><label>
                <input style=" color:#ff232d; width: 100%" type="text" name="clientSurname"
                       value="${client.getSurname()}"/>
            </label></td>
            <td><label>
                <input style=" color:#4dffcf; width: 100%" type="text" name="clientPhonenumber"
                       value="${client.getPhoneNumber()}"/>
            </label></td>
            <td><label>
                <input style=" color:#0e00ff; width: 100%" type="text" name="clientAdress"
                       value="${client.getAddress()}"/>
            </label></td>
            <td><label>
                <input style=" color:#ff6600; width: 100%" type="text" name="clientSumma"
                       value="${client.getSumma()}"/>
            </label></td>
            <td><label>
                <input style=" color:#ff007d; width: 100%" type="text" name="clientLastDate"
                       value="${client.getLastDate()}"/>
            </label></td>
            <tr></tr>
        </div>
        <td colspan="2"><input class="submit-button" style="width: 100%" type="submit" name="action" value="Add"/></td>
        <td><input class="submit-button" style="width: 100%" type="submit" name="action" value="Edit"/></td>
        <td colspan="2"><input class="submit-button" style="width: 100%" type="submit" name="action" value="Delete"/>
        </td>
        <td colspan="2"><input class="submit-button" style="width: 100%" type="submit" name="action" value="Search"/>
        </td>
        <tr></tr>
        <td colspan="7"><input class="submit-button" style="width: 100%;height: 50px" type="submit" name="action"
                               value="Return"/></td>
    </table>
    <h2 style="color: #ff0000; font-size: 15px;margin-left:10px;margin-bottom:10px"><%=messeg%>
    </h2>
    <%request.removeAttribute("message");%>

    <script>
        function search() {
            var xmlhttp;
            var clientnId = document.getElementsByName('clientnId').value;
            var clientName = document.getElementsByName('clientName').value;
            var clientSurname = document.getElementsByName('clientSurname').value;
            var clientPhonenumber = document.getElementsByName('clientPhonenumber').value;
            var clientAdress = document.getElementsByName('clientAdress').value;
            var clientSumma = document.getElementsByName('clientSumma').value;
            var clientLastDate = document.getElementsByName('clientLastDate').value;
            if (window.XMLHttpRequest) {
                // This part is mainly for the latest browsers which have XMLHttpRequest object
                // like Chrome,Firefox,Safari and IE7+
                xmlhttp = new XMLHttpRequest();
            }
            else {
                // This should take care of the older browsers
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                /*
                 readyState has four different states :
                 0: request not initialized
                 1: server connection established
                 2: request received
                 3: processing request
                 4: request finished and response is ready
                 status is ranging between 200 - Ok and 404 - Page Not Found
                 */
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("result").value = (xmlhttp.responseText);

                }
            };
            xmlhttp.open("GET", "ServletTest?clientnId=" + clientnId
                    + "&clientName=" + clientName
                    + "&clientSurname=" + clientSurname
                    + "&clientPhonenumber=" + clientPhonenumber
                    + "&clientAdress=" + clientAdress
                    + "&clientSumma=" + clientSumma
                    + "&clientLastDate=" + clientLastDate
                    , true);
            xmlhttp.send();
        }
    </script>

</form>
</body>
</html>

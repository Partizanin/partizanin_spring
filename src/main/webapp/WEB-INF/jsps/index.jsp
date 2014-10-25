<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <title>Вход</title>
    <link rel="stylesheet" href="../../css/style.css" type="text/css"/>
</head>

<body>
<h2>Authentication</h2>  <br/>
<%--<jsp:include page="WEB-INF/jsps/userAdd.jsp"/>--%>

<%
    String messeg = "";
    if (request.getAttribute("message") != null) {
        messeg = (String) request.getAttribute("message");
    }
%>
<div>
    <form action="/springHello" method="get">

        <label>
            <h2 style="color: #ff0000; font-family: Arial,serif; font-size: 20px;margin-left:170px;margin-bottom:-30px"><%=messeg%>
            </h2>
            <%
                request.removeAttribute("message");
            %>
            <label>Login:</label>
            <input style="margin-left: 50px;" type="text" name="login" value="Partizanin" placeholder="Логин">
        </label>
        <br/>
        <label>Password:</label>
        <label>
            <input type="password" name="password" value="123" placeholder="Пароль"/>
            <br/>
            <input class="inputLocation" type="submit" name="loginButton" value="Login"/>
            <input class="inputLocation" type="submit" name="registrationButton" value="Registration"/>
        </label>
    </form>
</div>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>

    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body>
<h2>Registration</h2>  <br/>
<%
    String messeg = "";
    if (request.getAttribute("message") != null) {
        messeg = (String) request.getAttribute("message");
    }
%>

<form action="/Controller" method="post">
    <h2 style="color: #ff0000; font-size: 20px;margin-left:170px;margin-bottom:-30px"><%=messeg%>
    </h2>
    <%
        request.removeAttribute("message");
    %>
    <label>Login:</label>
    <label>
        <input style="margin-left: 50px;" type="text" name="login">
    </label>
    <br/>
    <label>Password:</label>
    <label>
        <input type="password" name="password1">
        <br/>
    </label>
    <label style="margin-left: 150px">Confirm password:</label>
    <label>
        <input type="password" name="password2">
        <br/>
    </label>
    <input style="font-size: 20px" type="submit" name="RegistrationButton" value="Registration">

</form>
</body>
</html>

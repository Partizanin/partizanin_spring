<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <title>Вход aдминистратора</title>
    <link rel="stylesheet" href="/hw11/css/Login.css" type="text/css"/>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/ico">

</head>

<body>
<%
    String messeg = "";
    if (request.getAttribute("message") != null) {
        messeg = (String) request.getAttribute("message");
    }
%>

<form class="form-container" action="/LoginServlet" method="post">
    <div class="form-title"><h2 style="font-size: 40px">Sign up</h2></div>
    <h2 style="color: #ff0000; font-size: 20px;margin-left:10px;margin-bottom:-1px"><%=messeg%>
    </h2>
    <%request.removeAttribute("message");%>
    <div class="form-title">Login</div>
    <label>
        <input class="form-field" placeholder="Вася" type="text" name="loginAdmin"/>
    </label><br/>

    <div class="form-title">Password</div>
    <label>
        <input class="form-field" placeholder="abc123" type="password" name="passwordAdmin"/>
    </label><br/>

    <div class="submit-container">
        <input class="submit-button" type="submit" value="Submit" name="submitAdmin"/>
        <input class="registration-button" type="submit" name="registrationAdmin" value="Registration"/>
    </div>
</form>
</body>
</html>

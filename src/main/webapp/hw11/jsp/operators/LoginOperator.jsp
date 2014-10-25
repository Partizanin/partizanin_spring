<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <title>Вход оператора</title>
    <link rel="stylesheet" href="/hw11/css/Login.css" type="text/css"/>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/ico">

    <%
        String messeg = "";
        if (request.getAttribute("message") != null) {
            messeg = (String) request.getAttribute("message");
        }
    %>

</head>

<body>
<form class="form-container" action="/LoginServlet" method="post">
    <div class="form-title"><h2 style="font-size: 40px">Sign up</h2></div>
    <h2 style="color: #ff0000; font-family: Arial,serif; font-size: 20px;margin-left:10px;margin-bottom:5px"><%=messeg%>
    </h2>

    <div class="form-title">Login</div>
    <label>
        <input class="form-field" placeholder="Name" type="text" name="login"/>
    </label><br/>

    <div class="form-title">Password</div>
    <label>
        <input class="form-field" placeholder="Password" type="password" name="password"/>
    </label><br/>

    <div class="submit-container">
        <input class="submit-button" type="submit" value="Submit" name="submitOperator"/>
        <input class="registration-button" type="submit" name="registrationOperator" value="Registration"/>
    </div>
</form>
</body>
</html>

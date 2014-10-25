<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация администратора</title>

    <link rel="stylesheet" href="/hw11/css/Registration.css" type="text/css"/>
</head>
<body>

<%
    String messeg = "";
    if (request.getAttribute("message") != null) {
        messeg = (String) request.getAttribute("message");
    }
%>

<form style="margin-top: 80px" class="form-container" action="/Registration" method="post">
    <div class="form-title"><h2 style="font-size: 40px">Registration</h2></div>
    <h2 style="color: #ff0000; font-size: 20px;margin-left:10px;margin-bottom:-1px"><%=messeg%>
    </h2>
    <%request.removeAttribute("message");%>
    <div class="form-title">Login</div>
    <label>
        <input class="form-field" placeholder="Login" type="text" name="login"/>
    </label><br/>

    <div class="form-title">Password</div>
    <label>
        <input class="form-field" placeholder="Password" type="password" name="password"/>
    </label><br/>

    <div class="form-title">Confirm Password</div>
    <label>
        <input class="form-field" placeholder="Confirm password" type="password" name="confirm password"/>
    </label><br/>

    <div class="form-title">Login another administrator</div>
    <label>
        <input class="form-field" placeholder="Login another administration" type="text" name="another login"/>
    </label><br/>

    <div class="submit-container">
        <input class="submit-button" type="submit" name="backAdmin" value="Back"/>
        <input class="submit-button" type="submit" name="regAdmin" value="Registration"/>
    </div>
</form>
</body>
</html>

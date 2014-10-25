<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация оператора</title>

    <link rel="stylesheet" href="/hw11/css/Registration.css" type="text/css"/>
</head>
<body>
<%
    String messeg = "";
    if (request.getAttribute("message") != null) {
        messeg = (String) request.getAttribute("message");
    }
%>
<%--- логин
- идентификационный номер
- пароль и его подтверждение --%>
<form class="form-container" action="/Registration" method="post">
    <div class="form-title"><h2 style="font-size: 40px">Registration</h2></div>
    <h2 style="color: #ff0000; font-size:20px;margin-bottom:7px"><%=messeg%>
    </h2>
    <%request.removeAttribute("message");%>
    <div class="form-title">Login</div>
    <label>
        <input class="form-field" placeholder="Вася" type="text" name="login"/>
    </label><br/>

    <div class="form-title">Identification number:</div>
    <label>
        <input class="form-field" placeholder="12345" type="text" name="identification number"/>
    </label><br/>

    <div class="form-title">Password:</div>
    <label>
        <input class="form-field" placeholder="12355AAb" type="password" name="password"/>
    </label><br/>

    <div class="form-title">Confirm password:</div>
    <label>
        <input class="form-field" placeholder="12355AAb" type="password" name="password2"/>
    </label><br/>

    <div class="form-title">Login another operator</div>
    <label>
        <input class="form-field" placeholder="Login another operator" type="text" name="another login"/>
    </label><br/>

    <div class="submit-container">
        <input class="submit-button" type="submit" name="backOperator" value="Back"/>
        <input class="submit-button" type="submit" name="regOperator" value="Registration"/>
    </div>
</form>
</body>
</html>

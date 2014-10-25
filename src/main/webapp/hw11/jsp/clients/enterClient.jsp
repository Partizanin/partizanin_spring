<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <title>Вход</title>
    <link rel="stylesheet" href="/hw11/css/Login.css" type="text/css"/>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/ico">
</head>

<body>
<form class="form-container" action="/Enter" method="post">

    <h2 class="form-title" style="font-size: 30px">Administrators Control Panel</h2>

    <div class="submit-container" style="margin-right: 14px; margin-bottom:20px">
        <input style="width: 250px;" class="submit-button" type="submit" name="button" value="Show Clients List"/>
        <input style="width: 250px;" class="submit-button" type="submit" name="button" value="Show Operators List"/>
        <input style="width: 250px;" class="submit-button" type="submit" name="button"
               value="Show Administrators List"/>
    </div>
</form>
</body>
</html>

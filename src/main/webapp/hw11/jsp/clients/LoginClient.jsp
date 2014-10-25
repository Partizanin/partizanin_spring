<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <title>Вход клиента</title>
    <link rel="stylesheet" href="/hw11/css/Login.css" type="text/css"/>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/ico">

</head>

<body>

<%--<jsp:include page="WEB-INF/jsps/userAdd.jsp"/>--%>

<%
    String messeg = "";
    if (request.getAttribute("message") != null) {
        messeg = (String) request.getAttribute("message");
    }
%>

<form class="form-container" action="/LoginServlet" method="post">
    <div class="form-title"><h2 style="font-size: 40px">Sign up</h2></div>
    <h2 style="color: #ff0000; font-family: Arial,serif; font-size: 20px; margin-left:10px; margin-bottom:15px"><%=messeg%>
    </h2>

    <div class="form-title">Name</div>
    <label>
        <input class="form-field" placeholder="Вася" type="text" name="firstname"/>
    </label><br/>

    <div class="form-title">Surname</div>
    <label>
        <input class="form-field" placeholder="Пупкин" type="text" name="surname"/>
    </label><br/>

    <div class="submit-container">
        <input class="submit-button" type="submit" value="Submit" name="submitClient"/>
        <input class="registration-button" type="submit" name="registrationClient" value="Registration"/>
    </div>
</form>
</body>
</html>

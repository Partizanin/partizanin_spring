<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация клиента</title>

    <link rel="stylesheet" href="/hw11/css/Registration.css" type="text/css"/>
</head>
<body>
<%
    String messeg = "";
    if (request.getAttribute("message") != null) {
        messeg = (String) request.getAttribute("message");
    }
%>
<%--(имя, фамилия, телефон, адрес, сумма, дата последнего заказа)--%>
<form class="form-container" action="/Registration" method="post">
    <div class="form-title"><h2 style="font-size: 40px">Registration</h2></div>
    <h2 style="color: #ff0000; font-family: Arial,serif; font-size: 20px;margin-left:1px;margin-bottom:-30px"><%=messeg%>
    </h2>

    <div style="margin-top: 35px" class="form-title">Name</div>
    <label>
        <input class="form-field" placeholder="Вася" type="text" name="name"/>
    </label><br/>

    <div class="form-title">Surname</div>
    <label>
        <input class="form-field" placeholder="Пупкин" type="text" name="surname"/>
    </label><br/>

    <div class="form-title">Phone number:</div>
    <label>
        <input class="form-field" placeholder="+380988578992" type="text" name="phomeNumber"/>
    </label><br/>

    <div class="form-title">Address:</div>
    <label>
        <input class="form-field" placeholder="Meriladnd 12/1" type="text" name="address"/>
    </label><br/>

    <div class="form-title">Price:</div>
    <label>
        <input class="form-field" placeholder="65.30" type="text" name="price"/>
    </label><br/>

    <div class="form-title">Date of the last order:</div>
    <label>
        <input class="form-field" placeholder="12.05.2014" type="date" name="dateOfLastOrder"/>
    </label><br/>

    <div class="submit-container">
        <input class="submit-button" type="submit" name="backClient" value="Back"/>
        <input class="submit-button" type="submit" name="regClient" value="Registration"/>
    </div>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18.07.2014
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" href="css/Products.css" type="text/css"/>
    <title>Корзина</title>
</head>

<body style="text-align: center">
<form action="/ProductServlet" method="post">
    <label style="text-align: center">Number:</label>
    <input style="text-align: center" type="number" name="count"/>
    <input style="text-align: center" type="button" name="Add" value="Add"/>
    <input style="text-align: center" type="button" name="Remove" value="Remove"/>
</form>
</body>
</html>
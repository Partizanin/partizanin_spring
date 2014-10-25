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
    <title>Товары</title>
</head>
<body>

<form>
    <div>
        <p style="margin-left: 20px;margin-bottom: 10px;">Mineral Water</p>

        <a href="WEB-INF/jsps/Products.jsp"><img src="/images/mineral-water.jpg" class="border"></a>

        <p style="margin-left: 20px;margin-bottom: 10px">Price:8.50$</p>

    </div>
</form>


<form>
    <div>
        <p style="margin-left: 20px;margin-bottom: 10px">Bread</p>
        <a href="WEB-INF/jsps/Products.jsp"><img src="/images/Bread.jpg" class="border"></a>

        <p style="margin-left: 20px;margin-bottom: 10px">Price:4.50$</p>
    </div>
</form>

<form>
    <div>
        <p style="margin-left: 20px;margin-bottom: 10px">Eggs</p>
        <a href="WEB-INF/jsps/Products.jsp"><img src="/images/eggs.jpg" class="border"></a>

        <p style="margin-left: 20px;margin-bottom: 10px">Price:12.20$</p>
    </div>
</form>

<form>
    <div>
        <p style="margin-left: 20px;margin-bottom: 10px">Sugar</p>
        <a href="WEB-INF/jsps/Products.jsp"><img src="/images/sugar.jpg" class="border"></a>

        <p style="margin-left: 20px;margin-bottom: 10px">Price:12.30$</p>
    </div>
</form>

<form>
    <div>
        <p style="margin-left: 20px;margin-bottom: 10px">Meet</p>
        <%
            request.setAttribute("Meet", "Meet");
        %>

        <a href="/ProductServlet"><img src="/images/meet.jpg" class="border"></a>

        <p style="margin-left: 20px;margin-bottom: 10px">Price:20.30$</p>

    </div>
</form>


</body>
</html>
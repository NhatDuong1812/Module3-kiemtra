<%@ page import="model.Produce" %><%--
  Created by IntelliJ IDEA.
  User: Duong
  Date: 11/11/2020
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>

</head>
<body>
<%
    Produce produce = (Produce) request.getAttribute("produce");
%>
<form action="CreateProduceController?action=EditProduceController" method="post">


    <input type="submit" value="Create">

        Name :
        <input type="text " name="name" value="e">
        Prime:
        <input type="text " name="prime" value="<%=produce.getPrime()%>">
        Quantity:
        <input type="text " name="quantity" value="<%=produce.getQuantity()%>">
        Color:
        <input type="text " name="color" value="<%=produce.getColor()%>">
        Status:
        <input type="text " name="status" value="<%=produce.getStatus()%>">

    <input type="submit" value="Update">
</form>

</body>
</html>

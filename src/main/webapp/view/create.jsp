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
    <title>Create</title>

</head>
<body>
<%
    Produce produce = (Produce) request.getAttribute("produce");
%>
<form action="CreateProduceController?action=CreateProduceController" method="post">
    ID:
    <input type="text " name="id">
    Name :
    <input type="text " name="name">
    Prime:
    <input type="text " name="prime" >
    Quantity:
    <input type="text " name="quantity">
    Color:
    <input type="text " name="color" >
    Status:
    <input type="text " name="status">

    <input type="submit" value="Create">

</form>


</body>
</html>

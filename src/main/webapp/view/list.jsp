<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Produce</title>
</head>
<body>
<center>
    <h1>Produce Management</h1>
    <h2>
        <a href="/new">Add New produce</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Produce</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of produce</h2></caption>
        <tr>
            <th>ID</th>
            <th>name</th>
            <th>prime</th>
            <th>quantity</th>
            <th>color</th>
            <th>status</th>
        </tr>
        <c:forEach var="produce" items="${producelist}">
            <tr>
                <td><c:out value="${produce.id}" /></td>
                <td><c:out value="${produce.name}" /></td>
                <td><c:out value="${produce.prime}" /></td>
                <td><c:out value="${produce.quantity}" /></td>
                <td><c:out value="${produce.color}" /></td>
                <td><c:out value="${produce.status}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${produce.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${produce.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
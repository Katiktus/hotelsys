<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
    <title>Users</title>
</head>
<body>
<h1>Users list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Phone num</th>
    </tr>
    <c:forEach items="${usersObj}" var="room">
        <tr>
            <td>${room.userId}</td>
            <td>${room.name}</td>
            <td>${room.phoneNum}</td> </tr>
    </c:forEach>
</table>

<a href="/addUser">Create user</a>
<a href="/deleteUser">Delete user</a>
</body>
</html>

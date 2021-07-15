<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
    <title>Delete user</title>
</head>

<form action="${pageContext.request.contextPath}/deleteUser.html" method="post">
    <label>Enter user id</label>
    <input type="text" placeholder="Id" name="userId" value="${userId}" required/>
    <input type="submit" value="Delete"/>
</form>
<br>

<h1>Users list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Phone num</th>
        <th>Role Id</th>
        <th>Manager Id</th>
    </tr>
    <c:forEach items="${usersObj}" var="user">
        <tr>
            <td>${user.userId}</td>
            <td>${user.name}</td>
            <td>${user.phoneNum}</td>
            <td>${user.roleId}</td>
            <td>${user.managerId}</td>
        </tr>
    </c:forEach>
</table>



<a href="${pageContext.request.contextPath}/users.html">Back</a>
</body>
</html>
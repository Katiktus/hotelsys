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

<a href="${pageContext.request.contextPath}/addUser.html">Create user</a>
<a href="${pageContext.request.contextPath}/deleteUser.html">Delete user</a>
<a href="${pageContext.request.contextPath}/updateUserMgr.html">Update mgr</a>
<a href="${pageContext.request.contextPath}/updateUserPhone.html">Update phone</a>
<a href="${pageContext.request.contextPath}/updateUserRole.html">Update role</a>
<a href="${pageContext.request.contextPath}/index.jsp">Back</a>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Users list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Phone num</th>
    </tr>
    <c:forEach items="${objects}" var="element">
        <tr>
            <td>${element.userId}</td>
            <td>${element.name}</td>
            <td>${element.phoneNum}</td> </tr>
    </c:forEach>
</table>

<a href="/addUser">Create user</a>
<a href="/deleteUser">Delete user</a>
</body>
</html>

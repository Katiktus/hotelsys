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
    <body>
    ${users}
    <c:forEach items="${users}" var="element">
        <tr>
            <td>${element.userId}</td>
            <td>${element.name}</td>
            <td>${element.phoneNum}</td> </tr>
    </c:forEach>
    </body>
    </list>
</table>

<a href="/addUser">Create user</a>
</body>
</html>

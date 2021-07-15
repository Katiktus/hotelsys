<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user role</title>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
</head>
<body>
<h1>Fill the form, please</h1>
<br>
<form action="${pageContext.request.contextPath}/updateUserRole.html" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="userId" value="${userId}" required >
    <p>Role Id</p>
    <input title="Role Id" type="text" name="roleId" value="${roleId}" required>
    <input type="submit" value="Update">
</form>
<a href="${pageContext.request.contextPath}/users.html">Back</a>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new user</title>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
</head>
<body>
<h1>Fill the form, please</h1>
<br>
<form name="user" action="${pageContext.request.contextPath}/addUser" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="userId" value="${user.userId}" required>
    <p>Name</p>
    <input title="Name" type="text" name="name" value="${user.name}">
    <p>Role Id</p>  <!--Можно добавить выпадающий список-->
    <input title="Role Id" type="text" name="roleId" value="${user.roleId}">
    <p>Manager Id</p>
    <input title="Mgr Id" type="text" name="managerId" value="${user.managerId}">
    <p>Phone number</p>
    <input title="Phone number" type="text" name="phoneNumber" value="${user.phoneNumber}" minlength="13" maxlength="13"
    pattern="+380[0-9]{9}">
    <p>Hotel Id</p>  <!--Можно добавить выпадающий список-->
    <input title="Hotel Id" type="text" name="hotelId" value="${user.hotelId}">
    <input type="submit" value="Create">
</form>
<a href="${pageContext.request.contextPath}/users">Back</a>
</body>
</html>
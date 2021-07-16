<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user mgr</title>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
</head>
<body>
<h1>Fill the form, please</h1>
<br>
<form action="${pageContext.request.contextPath}/updateUserMgr" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="userId" value="${userId}" required>
    <p>Manager Id</p>
    <input title="Mgr Id" type="text" name="managerId" value="${managerId}" required>
    <input type="submit" value="Update">
</form>
<a href="${pageContext.request.contextPath}/users">Back</a>
</body>
</html>

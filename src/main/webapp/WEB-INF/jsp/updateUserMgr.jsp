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
<form action="${pageContext.request.contextPath}/updateUserMgr.html" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="userId" value="${userId}">
    <p>Manager Id</p>
    <input title="Mgr Id" type="text" name="managerId" value="${managerId}">
    <input type="submit" value="Update">
</form>

</body>
</html>

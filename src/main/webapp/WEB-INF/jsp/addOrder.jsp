<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new order</title>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
</head>
<body>
<h1>Fill the form, please</h1>
<br>
<form name="order" action="${pageContext.request.contextPath}/addOrder" method="post">
    <p>Customer id</p>
    <input title="Customer id" type="text" name="customerId" value="${order.customerId}" required>
    <p>Room number</p>
    <input title="Room number" type="text" name="roomNumber" value="${order.roomNumber}" min="0" required>
    <input type="submit" value="Create">
</form>
<a href="${pageContext.request.contextPath}/orders">Back</a>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: TANYA
  Date: 11.07.2021
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new room</title>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
</head>
<body>
<h1>Fill the form, please</h1>
<br>
<form name="room" action="${pageContext.request.contextPath}/addRoom.html" method="post">
    <p>Number</p>
    <input title="Number" type="text" name="roomNumber" value="${room.roomNumber}" required min="0">
    <p>Type</p> <!--Можно добавить выпадающий список-->
    <input title="Type" type="text" name="roomType" value="${room.roomType}">
    <p>Capacity</p>
    <input title="Capacity" type="text" name="capacity" value="${room.capacity}" min="1">
    <p>Price</p>
    <input title="Price" type="text" name="price" value="${room.price}" min="0">
    <p>Hotel id</p><!--Можно добавить выпадающий список-->
    <input title="Hotel id" type="text" name="hotelID" value="${room.hotelID}">
    <input type="submit" value="Create">
</form>
<a href="${pageContext.request.contextPath}/rooms.html">Back</a>
</body>
</html>

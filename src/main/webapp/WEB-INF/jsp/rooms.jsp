<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TANYA
  Date: 09.07.2021
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
    <title>Title</title>
</head>
<body>
<h1>Rooms list</h1>
<form action="${pageContext.request.contextPath}/freeRooms/roomNumber" method="post">
    <input type="submit" value="Get free rooms"/>
</form>
<table>
    <tr>
        <th><a href="${pageContext.request.contextPath}/rooms/roomNumber">Number</a></th>
        <th><a href="${pageContext.request.contextPath}/rooms/roomType">Type</a></th>
        <th><a href="${pageContext.request.contextPath}/rooms/capacity">Capacity</a></th>
        <th><a href="${pageContext.request.contextPath}/rooms/price">Price</a></th>
    </tr>
    <c:forEach items="${roomsObj}" var="room">
        <tr>
            <td>${room.roomNumber}</td>
            <td>${room.roomType}</td>
            <td>${room.capacity}</td>
            <td>${room.price}</td></tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/addRoom">Create room</a>
<a href="${pageContext.request.contextPath}/deleteRoom">Delete room</a>
<a href="${pageContext.request.contextPath}/updateRoomPrice">Update room price</a>
<a href="${pageContext.request.contextPath}/">Back</a>

<span id="placeToShow"></span>
</body>
</html>

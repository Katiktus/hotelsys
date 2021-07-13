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
<table>
    <tr>
        <th>Number</th>
        <th>Type</th>
        <th>Capacity</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${roomsObj}" var="room">
        <tr>
            <td>${room.roomNumber}</td>
            <td>${room.roomType}</td>
            <td>${room.capacity}</td>
            <td>${room.price}</td></tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/addRoom.html">Create room</a>
<a href="${pageContext.request.contextPath}/deleteRoom.html">Delete room</a>
<a href="${pageContext.request.contextPath}/updateRoomPrice.html">Update room price</a>
</body>
</html>

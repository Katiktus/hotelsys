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
<h1>Free rooms list</h1>

<table>
    <tr>
        <th><a href="${pageContext.request.contextPath}/freeRooms/roomNumber">Number</a></th>
        <th><a href="${pageContext.request.contextPath}/freeRooms/roomType">Type</a></th>
        <th><a href="${pageContext.request.contextPath}/freeRooms/capacity">Capacity</a></th>
        <th><a href="${pageContext.request.contextPath}/freeRooms/price">Price</a></th>
    </tr>
    <c:forEach items="${roomsObj}" var="room">
        <tr>
            <td>${room.roomNumber}</td>
            <td>${room.roomType}</td>
            <td>${room.capacity}</td>
            <td>${room.price}</td></tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/">Back</a>

</body>
</html>
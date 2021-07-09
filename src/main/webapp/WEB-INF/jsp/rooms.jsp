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
    <c:forEach items="${roomsObj}" var="element">
        <tr>
            <td>${element.roomNumber}</td>
            <td>${element.roomType}</td>
            <td>${element.capacity}</td>
            <td>${element.price}</td></tr>
    </c:forEach>
</table>

<a href="/addRoom">Create room</a>
<a href="/deleteRoom">Delete room</a>
</body>
</html>

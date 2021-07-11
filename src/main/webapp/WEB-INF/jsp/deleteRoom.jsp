<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
    <title>Delete room</title>
</head>
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

<br>
<a>Enter a number of room</a>
<input type="text" placeholder="Number"/>
<input type="submit" value="Delete"/>

<a href="${pageContext.request.contextPath}/rooms.html">Back</a>
</body>
</html>

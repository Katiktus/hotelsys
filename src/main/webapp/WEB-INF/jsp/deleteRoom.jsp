<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
    <title>Delete room</title>
</head>
<h1>Rooms list</h1>

<br>
<form action="${pageContext.request.contextPath}/deleteRoom.html" method="post">
<label>Enter a number of room</label>
<input type="text" placeholder="Number" name="roomNumber" value="${roomNumber}"/>
<input type="submit" value="Delete"/>
</form>
<br>

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


<a href="${pageContext.request.contextPath}/rooms.html">Back</a>
</body>
</html>

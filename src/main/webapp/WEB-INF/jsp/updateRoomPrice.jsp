<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update room</title>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
</head>
<body>
<h1>Fill the form, please</h1>
<br>
<form action="${pageContext.request.contextPath}/updateRoomPrice.html" method="post">
    <p>Number</p>
    <input title="Number" type="text" name="roomNumber" value="${roomNumber}">
    <p>Price</p>
    <input title="Price" type="text" name="price" value="${price}">
    <input type="submit" value="Update">
</form>

</body>
</html>
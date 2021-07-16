<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
    <title>Delete order</title>
</head>
<body>

<br>
<form action="${pageContext.request.contextPath}/deleteOrder" method="post">
    <label>Enter order id</label>
    <input type="text" placeholder="Id" name="orderId" value="${orderId}" required/>
    <input type="submit" value="Delete"/>
</form>
<br>

<h1>Orders list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Customer ID</th>
        <th>Room number</th>
    </tr>
    <c:forEach items="${ordersObj}" var="order">
        <tr>
            <td>${order.orderId}</td>
            <td>${order.customerId}</td>
            <td>${order.roomNumber}</td></tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/orders">Back</a>
</body>
</html>
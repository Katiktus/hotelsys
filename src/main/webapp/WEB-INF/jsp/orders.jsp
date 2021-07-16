<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
    <title>Title</title>
</head>
<body>
<h1>Orders list</h1>
<table>
    <tr>
        <th><a href="${pageContext.request.contextPath}/orders/id">Id</a></th>
        <th><a href="${pageContext.request.contextPath}/orders/customerId">Customer ID</a></th>
        <th><a href="${pageContext.request.contextPath}/orders/roomNumber">Room number</a></th>
    </tr>
    <c:forEach items="${ordersObj}" var="order">
        <tr>
            <td>${order.orderId}</td>
            <td>${order.customerId}</td>
            <td>${order.roomNumber}</td></tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/addOrder">Create order</a>
<a href="${pageContext.request.contextPath}/deleteOrder">Delete order</a>
<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>

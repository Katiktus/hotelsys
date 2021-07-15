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

<a href="${pageContext.request.contextPath}/addOrder.html">Create order</a>
<a href="${pageContext.request.contextPath}/deleteOrder.html">Delete order</a>
<a href="${pageContext.request.contextPath}/index.jsp">Back</a>
</body>
</html>

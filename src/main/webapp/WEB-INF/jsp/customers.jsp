<%--
  Created by IntelliJ IDEA.
  User: TANYA
  Date: 09.07.2021
  Time: 12:29
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
<h1>Customers list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Phone number</th>
    </tr>
    <c:forEach items="${customersObj}" var="element">
        <tr>
            <td>${element.customerId}</td>
            <td>${element.name}</td>
            <td>${element.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>

<a href="/addCustomer">Create customer</a>
<a href="/deleteCustomer">Delete customer</a>
</body>
</html>

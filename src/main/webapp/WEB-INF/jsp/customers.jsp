<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:forEach items="${customersObj}" var="customer">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.name}</td>
            <td>${customer.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/addCustomer.html">Create customer</a>
<a href="${pageContext.request.contextPath}/deleteCustomer.html">Delete customer</a>
<a href="${pageContext.request.contextPath}/updateCustomerPhone.html">Update phone number</a>
</body>
</html>

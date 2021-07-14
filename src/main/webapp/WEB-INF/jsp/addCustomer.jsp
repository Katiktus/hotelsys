<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
</head>
<body>
<h1>Fill the form, please</h1>
<br>
<form name="customer" action="${pageContext.request.contextPath}/addCustomer.html" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="customerId" value="${customer.customerId}">
    <p>Name</p>
    <input title="Name" type="text" name="name" value="${customer.name}">
    <p>Phone number</p>
    <input title="Phone number" type="text" name="phoneNumber" value="${customer.phoneNumber}">
    <input type="submit" value="Create">
</form>
<a href="${pageContext.request.contextPath}/customers.html">Back</a>
</body>
</html>
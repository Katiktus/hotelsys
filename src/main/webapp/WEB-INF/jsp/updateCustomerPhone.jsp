<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update customer number phone</title>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
</head>
<body>
<h1>Fill the form, please</h1>
<br>
<form action="${pageContext.request.contextPath}/updateCustomerPhone.html" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="id" value="${id}">
    <p>Phone number</p>
    <input title="Phone number" type="text" name="phone" value="${phone}">
    <input type="submit" value="Update">
</form>

</body>
</html>

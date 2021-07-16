<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
    <title>Users</title>
    <script>
        const request = new XMLHttpRequest();

        function searchInfo(){
            const name = document.username.username.value;
            const url = "1?val=" + name;
            try {
                request.onreadystatechange = function () {
                    if(request.readyState===4) {
                        document.getElementById("placeToShow").innerHTML=request.response;
                    }
                }
                request.open("GET", url, true);
                request.send();
            }
            catch (e) {
                alert('Unable connect to server'+e);
            }
        }
    </script>
</head>
<body>

<h1>Users list search</h1>
<form name="username" action="${pageContext.request.contextPath}/users/id" method="post">
    Name:
    <input type="text" value="" name="val" placeholder="Search" onkeyup="searchInfo()"/>
    <input type="submit" value="Enter">
</form>
<span id="placeToShow"></span>

<a href="${pageContext.request.contextPath}/addUser">Create user</a>
<a href="${pageContext.request.contextPath}/deleteUser">Delete user</a>
<a href="${pageContext.request.contextPath}/updateUserMgr">Update mgr</a>
<a href="${pageContext.request.contextPath}/updateUserPhone">Update phone</a>
<a href="${pageContext.request.contextPath}/updateUserRole">Update role</a>
<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>

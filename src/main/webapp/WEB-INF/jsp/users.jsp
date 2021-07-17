<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
    <title>Users</title>
    <script>
        function CreateRequest(){
            var Request = false;
            if (window.XMLHttpRequest){
                // for Gecko-browsers, Safari, Konqueror
                Request = new XMLHttpRequest();
            }else if (window.ActiveXObject){
                // for IE
                try{
                    Request = new ActiveXObject("Microsoft.XMLHTTP");
                }catch (CatchException){
                    Request = new ActiveXObject("Msxml2.XMLHTTP");
                }
            }
            if (!Request){
                alert("Can not create XMLHttpRequest");
            }
            return Request;
        }

        /*
        Send request to page
        r_method  - request type: GET / POST
        r_path    - path to file: file.jsp
        r_args    - request's arguments: a=1&b=2&c=3...
        r_handler - processing response function (callback)
        */
        function SendRequest(r_method, r_path, r_args, r_handler){
            //Create Request
            var Request = CreateRequest();
            if (!Request){
                return;
            }
            //Assign the Hendler
            Request.onreadystatechange = function(){
                if (Request.readyState != 4) return;
                if (Request.status != 200) {
                    alert("The Request status is '" + Request.status + "': " + Request.statusText);
                }else{
                    alert("something");
                    r_handler(Request);
                }
            }
            if (r_method.toLowerCase() == "get" && r_args.length > 0){
                r_path += "?" + r_args;
            }
            //Connection Init
            Request.open(r_method, r_path, true);
            if (r_method.toLowerCase() == "post"){
                //if POST-request than setup it's Header
                Request.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
                //send request
                Request.send(r_args);
            }else{
                //if it GET-request than send null
                Request.send(null);
            }
        }
    </script>
</head>
<body>

<h1>Users list search</h1>
<form name="username" action="${pageContext.request.contextPath}/users/id" method="post">
    Name:
    <input type="text" value="" name="val" placeholder="Search" onclick="SendRequest('GET', '1.jsp')"/>
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

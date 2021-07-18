<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
    <script>
        var request;
        var s = null;
        function test (num) {
            s = num;
        }
        function sendInfo()
        {
            var v=document.vinform.t1.value;

            if(s==null){
                s = "id";
            }
            var url="res/"+s+"?val="+v;

            if(window.XMLHttpRequest){
                request=new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
                request=new ActiveXObject("Microsoft.XMLHTTP");
            }

            try{
                request.onreadystatechange=getInfo;
                request.open("GET",url,true);
                request.send();
            }catch(e){alert("Unable to connect to server");}
        }

        function getInfo(){
            if(request.readyState==4){
                var val=request.responseText;
                document.getElementById('amit').innerHTML=val;
            }
        }

    </script>
</head>
<body onload="sendInfo()">
<h1>User list</h1>
<form name="vinform">
    Enter name:<input type="text" name="t1" value="" onchange="sendInfo()">
</form>

<span id="amit"> </span>
<a href="${pageContext.request.contextPath}/addUser">Create user</a>
<a href="${pageContext.request.contextPath}/deleteUser">Delete user</a>
<a href="${pageContext.request.contextPath}/updateUserMgr">Update mgr</a>
<a href="${pageContext.request.contextPath}/updateUserPhone">Update phone</a>
<a href="${pageContext.request.contextPath}/updateUserRole">Update role</a>
<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>
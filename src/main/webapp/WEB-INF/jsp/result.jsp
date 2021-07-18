<%@ page import="ua.edu.sumdu.j2ee.pohorila.hotelsys.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        <%@include file='../css/hotel.css' %>
    </style>
    <title>Title</title>
</head>
<body>
<%
    String s=request.getParameter("val");
        System.out.println(s);
        try{
            %>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Phone num</th>
        <th>Role Id</th>
        <th>Manager Id</th>
    </tr>
<%
            for (User user: (ArrayList<User>)request.getAttribute("users")) {
                if(user.getName().contains(s) || s.isEmpty()){
                    %>
<tr>
    <td><%=user.getUserId()%></td>
    <td><%=user.getName()%></td>
    <td><%=user.getPhoneNum()%></td>
    <td><%=user.getRoleId()%></td>
    <td><%=user.getManagerId()%></td>
</tr>

<%
                }
        }
        }catch(Exception e){e.printStackTrace();}

%>
</table>
</body>
</html>
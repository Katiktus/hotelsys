<%@ page import="ua.edu.sumdu.j2ee.pohorila.hotelsys.dao.HotelsysDao" %>
<%@ page import="ua.edu.sumdu.j2ee.pohorila.hotelsys.model.UserList" %>
<%@ page import="ua.edu.sumdu.j2ee.pohorila.hotelsys.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<User> list;
    String name = request.getParameter("val");
    if (name.isEmpty()||name.trim().equals("")){
        list = HotelsysDao.getInstance().getAllUsers().getArr();
    }else {
        list = HotelsysDao.getInstance().getUsersByName(name).getArr();
    }
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
        for (User user:list) {
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
    %>
</table>
</body>
</html>

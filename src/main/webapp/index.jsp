<!--<html>
<head>
    <title>Test</title>
</head>
<body>
    <h1 style="text-align: center">Test index.jsp page</h1>
    <h2 style="text-align: center">
        <a href="welcome.html">Click here</a> for a Welcome page.
    </h2>
</body>
</html>
-->
<html>
<head>
    <style>
        <%@include file='WEB-INF/css/hotel.css' %>
    </style>
</head>
<body>
<h1>Welcome to our hotel system</h1>
<table>
    <tr>
        <td>
            <a href="rooms.jsp">Rooms</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="customers.jsp">Customers</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="users.jsp">Users</a>
        </td>
    </tr>
</table>
</body>
</html>
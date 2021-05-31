<%@ page import="java.util.List" %>
<%@ page import="java.net.UnknownServiceException" %>
<%@ page import="model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: m14
  Date: 15.05.2021
  Time: 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<User> users =
        (List<User>)request.getAttribute("userNames");

%>
<html>
<head>
    <title>Users</title>
</head>

<body>

<div>
    <div>
        <div>
            <h2>Users:</h2>
        </div>
        <table border="1">
            <thead>
            <th>Id:</th>
            <th>Username:</th>
            <th>Password:</th>
            <th>Gender:</th>
            </thead>
            <tbody>
            <%for(User s:users){%>

            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getUsername()%></td>
                <td><%=s.getGender()%></td>
                <td><%=s.getPassword()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>

<div>
    <div>
        <button onclick="location.href='/'">Add new user Page</button>
        <button onclick="location.href='/deleteuser.jsp'">Delete user Page</button>
    </div>
</div>

<div>
    <button onclick="location.href='/index.jsp'">Return to main</button>
</div>

</body>
</html>

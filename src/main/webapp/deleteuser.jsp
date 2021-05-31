
<%--  Created by IntelliJ IDEA.--%>
<%--  User: m14--%>
<%--  Date: 15.05.2021--%>
<%--  Time: 1:34--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Delete user</title>
</head>

<body>

<div>
    <div>
        <h2>Delete user:</h2>
    </div>

    <form action="/deleteuser" method="post">

        <label>Name:
            <input type="text" required name="username"><br />
        </label>

        <label>Password:
            <input type="password" required name="password"><br />
        </label>

        <button type="submit">Delete user</button>
    </form>

<%--    <%--%>
<%--        if (request.getAttribute("name") != null) {--%>
<%--            out.println("<p>User '" + request.getAttribute("name") + "' deleted!</p>");--%>
<%--        }--%>
<%--    --%>
<%--    %>--%>

</div>

<div>
    <button onclick="location.href='index.jsp'">Return to main</button>

</div>
</body>
</html>

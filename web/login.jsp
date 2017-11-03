<%--
  Created by IntelliJ IDEA.
  User: QUANG
  Date: 10/11/2017
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    if (session.getAttribute("username") != null) response.sendRedirect("info.jsp");
%>
<form action="loginsl" method="post">
    <label>Login</label><br>
    Username: <input type="text" value="" name="username">
    Password: <input type="password" value="" name="password">
    <input type="submit" value="Login">
</form>
<br>
<a href="register.jsp">Chưa có tài khoản?</a>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: QUANG
  Date: 10/16/2017
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registersl" method="post" title="register" name="register">
    Họ và tên: <input type="text" title="hoten" name="hoten"><br><br>
    Ngày sinh: <input type="date" title="ngaysinh" name="ngaysinh"><br><br>
    Quê quán: <input type="text" title="quequan" name="quequan"><br><br>
    Username: <input type="text" title="username" name="username"><br><br>
    Password: <input type="password" title="password1" name="password1"><br><br>
    Repassword: <input type="password" title="password2" name="password2"><br><br>
    <input type="submit" value="Register">
</form>
</body>
</html>

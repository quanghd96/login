<%@ page import="com.quang.connect.DatabaseConnect" %>
<%@ page import="com.quang.models.entity.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: QUANG
  Date: 10/17/2017
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<%
    DatabaseConnect connect = new DatabaseConnect();
    String username = (String) session.getAttribute("username");
    User user = connect.getUser(username);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
%>
<%=
"Họ và tên: " + user.getHoten() + "<br> Ngày sinh: " + simpleDateFormat.format(user.getNgaysinh()) + "<br>"
        + "Quê quán: " + user.getQuequan()
%>
<form action="${pageContext.request.contextPath}/information" method="post">
    <input type="submit" value="Chỉnh sửa thông tin cá nhân" name="modify">
    <input type="submit" value="Đăng xuất" name="signout">
</form>
</body>
</html>

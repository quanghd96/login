<%@ page import="com.quang.connect.DatabaseConnect" %>
<%@ page import="com.quang.models.entity.User" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: QUANG
  Date: 10/17/2017
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa thông tin cá nhân</title>
</head>
<body>
<%
    DatabaseConnect connect = new DatabaseConnect();
    String username = (String) session.getAttribute("username");
    User user = connect.getUser(username);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
%>
<form action="${pageContext.request.contextPath}/modify" method="post" title="modify" name="modify">
    Họ và tên: <input type="text" title="hoten" name="hoten" value="<%= user.getHoten() %>"><br><br>
    Ngày sinh: <input type="date" title="ngaysinh" name="ngaysinh"
                      value="<%= simpleDateFormat.format(user.getNgaysinh()) %>"><br><br>
    Quê quán: <input type="text" title="quequan" name="quequan" value="<%= user.getQuequan() %>"><br><br>
    Username: <%= "<b>" + user.getUsername() + "</b>" %><br><br>
    Password: <input type="password" title="password1" name="password1"><br><br>
    Repassword: <input type="password" title="password2" name="password2"><br><br>
    <input type="submit" value="Lưu">
</form>
</body>
</html>

package com.quang.servlets;

import com.quang.models.DatabaseManagement;
import com.quang.models.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoten = request.getParameter("hoten");
        String ngaysinh = request.getParameter("ngaysinh");
        String quequan = request.getParameter("quequan");
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            try {
                Date ns = simpleDateFormat.parse(ngaysinh);
                User user = new User(hoten, ns, quequan, username, password1);
                DatabaseManagement dm = new DatabaseManagement();
                if (dm.register(user)) {
                    response.sendRedirect("login.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
            } catch (ParseException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
        response.getWriter().println(hoten);
    }
}

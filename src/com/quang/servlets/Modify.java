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

public class Modify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseManagement databaseManagement = new DatabaseManagement();
        String hoten = request.getParameter("hoten");
        String ns = request.getParameter("ngaysinh");
        String quequan = request.getParameter("quequan");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String username = (String) request.getSession().getAttribute("username");
        if (password1.equals(password2)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            try {
                User user = new User(hoten, simpleDateFormat.parse(ns), quequan, username, password1);
                databaseManagement.modify(user);
                response.sendRedirect("info.jsp");
            } catch (ParseException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}

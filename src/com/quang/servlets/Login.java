package com.quang.servlets;

import com.quang.models.DatabaseManagement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DatabaseManagement dm = new DatabaseManagement();
        if (dm.checkUser(username, password)) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.sendRedirect("info.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}

package com.LiuXingyan.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String pass=request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String date=request.getParameter("date");

        PrintWriter writer=response.getWriter();
        writer.println("<br>username :"+name);
        writer.println("<br>password :"+pass);
        writer.println("<br>email :"+email);
        writer.println("<br>gender :"+sex);
        writer.println("<br>birthdate :"+date);
        writer.close();
    }
}

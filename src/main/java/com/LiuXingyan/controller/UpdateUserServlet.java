package com.LiuXingyan.controller;

import com.LiuXingyan.dao.UserDao;
import com.LiuXingyan.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String mail=request.getParameter("email");
        String sex=request.getParameter("gender");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate= null;
        try {
            System.out.println(request.getParameter("birthDate").trim());
            birthDate = (Date) simpleDateFormat.parse(request.getParameter("birthDate").trim());
        } catch (ParseException e) {
            System.out.println(e);
        }
        String id=request.getParameter("id");
        User u=new User(Integer.valueOf(id),username,password,mail,sex,birthDate);
        UserDao userDao=new UserDao();
        try {
            userDao.updateUser((Connection)getServletContext().getAttribute("con"),u);
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println(birthDate);
        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
    }
}

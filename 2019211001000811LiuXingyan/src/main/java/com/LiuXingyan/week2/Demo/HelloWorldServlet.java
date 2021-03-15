package com.LiuXingyan.week2.Demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer=response.getWriter();
        writer.println("Name:Liu Xingyan");
        writer.println("ID:2019211001000811");
        writer.println("Date and Time:Sun March 14 15:23:00 CST 2021");

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response){

    }

}

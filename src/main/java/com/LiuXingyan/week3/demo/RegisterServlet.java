package com.LiuXingyan.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException{
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("init()--> "+con);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out= response.getWriter();
        String username=request.getParameter("name");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("date");

        try{
            String sql1="insert into usertable(username,password,email,gender,birthdate) values(?,?,?,?,?);";
            PreparedStatement pstmt=con.prepareStatement(sql1);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,email);
            pstmt.setString(4,gender);
            pstmt.setString(5, String.valueOf(Date.valueOf(birthdate)));
            int result=pstmt.executeUpdate();
            if(result==1) System.out.println("OK");
            else System.out.println("ERROR");

            String sql="select * from usertable";
            ResultSet rs=con.createStatement().executeQuery(sql);
            out.println("<html>");
            out.println("<body>");
            while(rs.next()){
                out.println("<table border=\\\"1\\\">");
                out.println("<tr>");
                out.println("<th>ID:"+rs.getString(1)+"</th>");
                out.println("<th>UserName:"+rs.getString(2)+"</th>");
                out.println("<th>Passsword:"+rs.getString(3)+"</th>");
                out.println("<th>Email:"+rs.getString(4)+"</th>");
                out.println("<th>Gender:"+rs.getString(5)+"</th>");
                out.println("<th>Birthdate:"+rs.getString(6)+"</th>");
                out.println("</tr>");
                out.println("</table>");
            }
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

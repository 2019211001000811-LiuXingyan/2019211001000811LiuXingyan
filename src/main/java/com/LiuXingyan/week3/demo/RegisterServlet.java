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
    Connection con = null;

    public void init() throws ServletException {
        super.init();
        /*ServletConfig config=getServletConfig();
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
        }*/
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("date");

        try {
            Statement st = con.createStatement();
            String sql = "insert into usertable(username,password,email,gender,birthdate)" + "values('" + username + "," + password + "," + email + "," + gender + "," + birthdate + "')";
            System.out.println("sql" + sql);
            int n = st.executeUpdate(sql);
            System.out.println("n-->" + n);
            /*sql="select id,username,password,email,gender,birthdate from usertable";
            ResultSet rs=st.executeQuery(sql);
            PrintWriter out=response.getWriter();
            out.println("<html><title></title><body><table border=1><tr>");
            out.println("<td>Username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthdate</td>");
            while (rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("password")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("gender")+"</td>");
                out.println("<td>"+rs.getString("birthdate")+"</td>");
                out.println("</tr>");
            }
            out.println("</table></body></html>");
            request.setAttribute("rsname",rs);
            request.getRequestDispatcher("userList.jsp").forward(request,response);
            */
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

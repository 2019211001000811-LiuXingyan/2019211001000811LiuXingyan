<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/14
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
<h1><%= "New User Registration!" %>
</h1>
<form method="post" action="register">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
    Date of Birth:<input type="text name=" name="birthDate"><br/>
    <input type="submit" value="Register"/>
</form>
<%@include file="footer.jsp"%>


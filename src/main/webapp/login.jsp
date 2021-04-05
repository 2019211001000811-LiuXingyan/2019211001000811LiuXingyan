<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/4/4
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>

<h1><%= "Login" %>
</h1>
<form method="post" action="/login">
    Username:<input type="text" name="username" ><br/>
    Password:<input type="password" name="password" ><br/>
    <input type="submit" value="Login"/>
</form>

<%@include file="footer.jsp"%>

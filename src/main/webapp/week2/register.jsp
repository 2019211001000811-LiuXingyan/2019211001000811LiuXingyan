<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/14
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%= "New User Registration!" %>
</h1>
<form method="post">
    <input type="text" name="name" placeholder="Username"><br/>
    <input type="password" name="pass" placeholder="password" required minlength="8"><br/>
    <input type="email" name="email" placeholder="Email"><br/>
    Gender
    <label><input type="radio" name="sex">Male</label>
    <label><input type="radio" name="sex">Female</label><br/>
    <input type="date" name="date" placeholder="Date of Birth(yyyy-mm-dd)"><br/>
    <input type="submit" value="Register"/>
</form>

</body>
</html>

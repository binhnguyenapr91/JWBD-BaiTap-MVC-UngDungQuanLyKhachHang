<%--
  Created by IntelliJ IDEA.
  User: binhnguyen
  Date: 16/05/2020
  Time: 00:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/login" method="post">
    User name :<input type="text" name="username" />
    password :<input type="password" name="password" />
    <input type="submit" value="Login"/>
</body>
</html>

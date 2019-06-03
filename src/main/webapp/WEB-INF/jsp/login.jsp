<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-26
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="get" action="/user/login">
        用户名：<input type="text" name="name"/><br/>
        密码：  <input type="password" name="pwd"/><br/>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>

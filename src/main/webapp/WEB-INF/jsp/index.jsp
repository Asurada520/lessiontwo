<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-24
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    This is index jsp page.
    <span>您已经成功访问到主页面！</span>
    <hr />
    welcome <span th:text="${name}"></span>
</body>
</html>

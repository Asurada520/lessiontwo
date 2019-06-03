<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-28
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
    <span>单个文件上传</span><br/>
    <form action="/file/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" value="upload file"/>
    </form>

    <span>多个文件上传</span><br/>
    <form action="/file/uploads" method="post" enctype="multipart/form-data">
        <span>文件1: </span><input type="file" name="file"/><br/>
        <span>文件2: </span><input type="file" name="file"/><br/>
        <span>文件3: </span><input type="file" name="file"/><br/>
        <input type="submit" value="upload file"/>
    </form>

</body>
</html>

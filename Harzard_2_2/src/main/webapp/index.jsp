<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2018/11/27
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Harzard</title>
    <link rel="stylesheet" href="css/index.css" type="text/css">
</head>
<body>
<%--<div id="frame">
    <img src="img/frame.jpg" alt="主页面" height="80%">
</div>--%>
<form action="userList" method="post">
<div><label>用户名: <input type="text" name="userName"></label></div>
<div><label>密码: <input type="password" name="pwd"></label></div>
    <div><input type="submit" value="登录"><button>注册</button></div>
</form>
</body>
</html>
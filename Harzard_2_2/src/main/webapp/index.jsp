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
    <style type="text/css">
        body{
            text-align: center;
            background-color: aquamarine;
        }
        #login {
            font-size: 300%;
            color: blue;
        }

        input {
            font-size: 100%;
        }
    </style>
</head>
<body>
<%--<div id="frame">
    <img src="img/frame.jpg" alt="主页面" height="80%">
</div>--%>
<form action="userList" method="post" id="login">
    <br>
    <div><label>用户名: <input type="text" name="username" required="required" style="width:250px;height:50px"></label></div>
    <br>
    <div><label>密码:&nbsp;&nbsp;&nbsp; <input type="password" name="pwd" required="required" style="width:250px;height:50px"></label></div>
    <br>
    <div><input type="submit" value="登录" name="" style="width:200px;height:70px;background-color: yellow">
        &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="register.jsp" style="color: green">注册</a>
    </div>
    <input type="hidden" name="opr" value="login">
</form>
</body>
</html>

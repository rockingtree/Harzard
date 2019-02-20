<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2019/2/2
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
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
<form action="userList" method="post" id="login" name="opr">
    <br>
    <div><label>用户名:&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="username" required="required"
               value="<%=request.getParameter("username")==null?"":request.getParameter("username")%>"
               style="width:250px;height:50px"></label></div>
    <br>
    <div><label>密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="password" name="pwd" required="required" style="width:250px;height:50px"></label></div>
    <br>
    <div><label>确认密码:&nbsp;<input type="password" name="pwdCfm" required="required" style="width:250px;height:50px"></label></div>
    <br>
    <div><input type="submit" value="提交" style="width:200px;height:70px;background-color: yellow">
    </div>
    <input type="hidden" name="opr" value="register">
</form>
</body>
</html>

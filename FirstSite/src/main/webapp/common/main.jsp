<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2019/2/2
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
    <style type="text/css">body{
        background-color: aquamarine;
        font-size: 300%;
        text-align: center;
    }</style>
</head>
<body>
<br>
欢迎，<span style="color: blue"><%=request.getParameter("username")%></span>
<br>
<ul style="list-style: none;line-height: 80px;">
    <li><a href="../common/game.jsp" target="_blank" style="text-decoration: none; color: red">开始游戏</a></li>
    <li><a href="#" style="text-decoration: none;color:red;" >管理卡组</a></li>
    <li></li>
    <li><a href="../index.jsp" style="text-decoration: none;color: grey">退出登录</a></li>
</ul>
</body>
</html>

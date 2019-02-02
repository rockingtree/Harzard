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
        font-size: 300%;
        text-align: center;
    }</style>
</head>
<body>
<br>
欢迎，<%=request.getParameter("username")%>
<br>
<ul>
    <li>开始游戏</li>
    <li>管理卡组</li>
    <li><a href="../index.jsp">退出登录</a></li>
</ul>
</body>
</html>

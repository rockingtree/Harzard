<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2019/1/29
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
    <style type="text/css">
        body{
            font-size: 300%;
            text-align: center;
        }
        input{
           font-size: 100%;
         }
    </style>
</head>
<body>
<a href="http://www.baidu.com"><img src="img/pc.jpg" alt=""></a>
<p>登陆成功</p>
<form action="calcServlet" method="post">
    <div>
        <label>
            输入算式:
            <input type="text" name="equation" style="width:250px;height:50px"
                   value="<%=request.getParameter("equation")==null?
                   "":request.getAttribute("equation")%>">
        </label>
        <input type="submit" value="等于" style="width:120px;height:80px">
        <input type="text" name="result" size="8" style="width:150px;height:50px"
               value="<%=request.getAttribute("result")==null?
               "":request.getAttribute("result")%>">
    </div>
</form>
</body>
</html>

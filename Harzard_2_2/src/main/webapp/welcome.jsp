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
</head>
<body>
登陆成功
<form action="calcServlet" method="post">
    <div>
        <label>
            输入算式:
            <input type="text" name="equation"
                   value="<%=request.getParameter("equation")==null?
                   "":request.getAttribute("equation")%>">
        </label>
        <input type="submit" value="等于">
        <input type="text" name="result" size="8"
               value="<%=request.getAttribute("result")==null?
               "":request.getAttribute("result")%>">
    </div>
</form>
<img src="img/frame.jpg">
</body>
</html>

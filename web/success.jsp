<%--
  Created by IntelliJ IDEA.
  User: 子期
  Date: 2018/7/6
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登录成功</title>
    <link rel="icon" href="ic_launcher.png" type="image/x-icon"/>
</head>
<body bgcolor="#d3d3d3">
    <h1 style="color: darkmagenta; text-align: center">登录成功~！</h1>
    <div align="center">
        <strong>${msg}</strong><br><br>
        <a href="${pageContext.request.contextPath}/showall.action">
            <input type="button" value="查看所有用户" />
        </a>
        <a href="query.jsp">
            <input type="button" value="查询用户" />
        </a>
    </div>
</body>
</html>

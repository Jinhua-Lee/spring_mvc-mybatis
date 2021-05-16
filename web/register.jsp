<%--
  Created by IntelliJ IDEA.
  User: 子期
  Date: 2018/7/7
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>用户注册</title>
        <link rel="icon" href="ic_launcher.png" type="image/x-icon"/>
    </head>

    <body bgcolor="#d3d3d3">
        <h1 style="color: darkmagenta; text-align: center">用户注册</h1>
        <hr>
        <form action="${pageContext.request.contextPath}/register.action" method="post">
            <p>姓名：<input type="text" name="name">${registerErrors.nameError}</p>
            <p>密码：<input type="password" name="pwd">${registerErrors.pwdError}</p>
            <p>密码：<input type="password" name="pwdConfig">${pwdconfigError}</p>
            <p>性别：
                <input type="radio"value="男" name="sex" checked>男&nbsp;
                <input type="radio" name="sex" value="女">女</p>
            <p>${registerErrors.sex}</p>
            <p>家乡：
                <select name="home">
                    <option value="" selected="selected">----请选择----</option>
                    <option value="成都">成都</option>
                    <option value="武汉">武汉</option>
                    <option value="土耳其">土耳其</option>
                    <option value="上海">上海</option>
                    <option value="巴黎">巴黎</option>
                </select>
            </p>
            <p>备注：<input type="text" name="info"></p>
            <p><input type="submit" name="submit" value="提交"></p>
            <p><input type="reset" name="reset" value="重置"></p>
        </form>
    </body>
</html>

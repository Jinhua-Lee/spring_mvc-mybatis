<%--
  Created by IntelliJ IDEA.
  User: 子期
  Date: 8/24/2018
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有用户信息</title>
    <link rel="icon" href="ic_launcher.png" type="image/x-icon"/>
</head>
<body bgcolor="d3d3d3">
    <h1 align="center">所有用户信息</h1>
    <div>
        <table width="800px" border="1" cellpadding="0" align="center">
            <tr bgcolor="#ff7f50">
                <th>ID</th>
                <th>姓名</th>
                <th>密码</th>
                <th>性别</th>
                <th>家乡</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${userList}" var="U">
                <form action="${pageContext.request.contextPath}/update.action" method="post">
                    <input type="hidden" name="pageBean.pageSize" value="${pageBean.pageSize}">
                        <%--表单数据分行显示--%>
                    <tr>
                        <td bgcolor="#ccccff">
                            <input class="input_wid" type="text" value="${U.id}" name="id" readonly="readonly">
                        </td>
                        <td bgcolor="#ccff99">
                            <input class="input_wid" type="text" value="${U.name}" name="name">
                        </td>
                        <td bgcolor="#ccccff">
                            <input class="input_wid" type="text" value="${U.pwd}" name="pwd">
                        </td>
                        <td bgcolor="#ccff99">
                            <input class="input_wid" type="text" value="${U.sex}" name="sex">
                        </td>
                        <td bgcolor="#ccccff">
                            <input class="input_wid" type="text" value="${U.home}" name="home">
                        </td>
                        <td bgcolor="#ccff99">
                            <input class="input_wid" type="text" value="${U.info}" name="info">
                        </td>
                        <td bgcolor="#ccccff">
                            <a href="${pageContext.request.contextPath}/delete.action?id=${U.id}">
                                    <%--这里传递的参数是一个id，没有传递表单数据--%>
                                <input type="button" value="删除">
                            </a>
                            <a>
                                    <%--这里是submit方法，传递一行数据--%>
                                <input type="submit" value="更新">
                            </a>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </div>
</body>
</html>

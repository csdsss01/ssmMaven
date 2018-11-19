<%--
  Created by IntelliJ IDEA.
  User: ZZYR
  Date: 2018/11/7
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h3>用户列表</h3>
    <a href="tzAdd">添加</a>
    <table border="1" width="600px;">
        <tr><td>员工名</td><td>职位</td><td>薪酬</td><td>操作</td></tr>
        <c:forEach items="${empList}" var="emp">
            <tr><td>${emp.ENAME}</td><td>${emp.JOB}</td><td>${emp.SAL}</td><td><a href="ByidList?empno=${emp.EMPNO}&&pageNo=${pageNo}">修改 </a>&nbsp;<a href="deleteFF?empno=${emp.EMPNO}&&pageNo=${pageNo}">删除 </a> </td></tr>
        </c:forEach>
        <div>
            ${stringPage}
        </div>
    </table>
</center>
</body>
</html>

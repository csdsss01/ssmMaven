<%--
  Created by IntelliJ IDEA.
  User: ZZYR
  Date: 2018/11/7
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<center>
    <h3>用户修改</h3>
    <form action="update?pageNo=${pageNo}" method="post">
        <table border="1" width="600px;">
    <c:forEach items="${mapList}" var="list">
            <tr>
                <td>员工姓名</td>
                <td><input type="text" name="ename" value="${list.ENAME}"></td>
            </tr>
            <tr>
                <td>员工职务</td>
                <td><input type="text" name="job"  value="${list.JOB}"></td>
            </tr>
            <tr>
                <td>员工薪资</td>
                <td><input type="text" name="sal"  value="${list.SAL}"></td>
            </tr>
        <tr style="display: none">

            <td><input type="text" name="empno"  value="${list.EMPNO}"></td>
        </tr>
    </c:forEach>
        </table>
        <input type="submit" value="修改">

    </form>


</center>
</body>
</html>

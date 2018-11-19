<%--
  Created by IntelliJ IDEA.
  User: ZZYR
  Date: 2018/11/7
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增</title>
</head>
<body>
<center>
    <h3>用户添加</h3>
<form action="add" method="post">
    <table border="1" width="600px;">
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="ename"></td>
        </tr>
        <tr>
            <td>员工职务</td>
            <td><input type="text" name="job"></td>
        </tr>
        <tr>
            <td>员工薪资</td>
            <td><input type="text" name="sal"></td>
        </tr>
    </table>
    <input type="submit" value="添加">

</form>


</center>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>
    展示
  </title>
</head>
  <br>表格例子
  <a href="add.jsp">添加</a>
<table border="1" cellspacing="0">
  <tr>
    <td>队员ID</td>
    <td>姓名</td>
    <td>性别</td>
    <td>年龄</td>
    <td>地址</td>
    <td>操作</td>
    <td>操作</td>
  </tr>
  <c:forEach var="player" items="${players}" >
    <tr>
      <td>${player.playerID}</td>
      <td>${player.name}</td>
      <td>${player.sex}</td>
      <td>${player.age}</td>
      <td>${player.address}</td>
      <td><a href="deleteServlet?PlayerID=${player.playerID}">删除</a></td>
      <td><a href="editServlet?PlayerID=${player.playerID}">编辑</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
</head>
<body>
  添加读者
  <form  action="addServlet" method="post">
    <div style="width:200px;height:330px;border:1px solid;padding:20px ">

       <br>读者id<br>
      <input type="text" name="PlayerID">
      <br>姓名<br>
      <input type="text" name="Name">
      <br>性别<br>
      <input type="text" name="Sex">
      <br>年龄<br>
      <input type="text" name="Age">
      <br>籍贯<br>
      <input type="text" name="Address">
      <p>
      <input type="submit" value="添加">
      <input type="reset" value="重置">
    </div>
  </form>

</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
</head>
<body>
添加读者
<form  action="showServlet" method="post" onsubmit="return checkForm();">
    <div style="width:200px;height:330px;border:1px solid;padding:20px ">

        <br>读者id<br>
        <input type="text" name="PlayerID" value="${player.playerID}" >
        <br>姓名<br>
        <input type="text" name="Name" value="${player.name}" id="name">
        <br>性别<br>
        <input type="text" name="Sex" value="${player.sex}" >
        <br>年龄<br>
        <input type="text" name="Age" value="${player.age}" id="age">
        <br>籍贯<br>
        <input type="text" name="Address" value="${player.address}">
        <p>
            <input type="submit" value="修改">
            <input type="reset" value="重置">
    </div>
</form>

</body>
<script>
    var bage = document.getElementById("age")
    var bname = document.getElementById("name")

    function checkForm(){
        var max = ""
        var cage = checkAge();
        var cname = checkName();
        max = cage + cname;
        // if(!max){
        //     alert(max)
        // }
    }

    function checkAge(){
        let value = bage.value
        let msg = ""
        if(!value){
            msg = "未添加年龄"
        }
        if(value>100||value<1){
            msg = "年龄未达标"
        }
        // alert(value)
        if(msg){
            alert(msg)
        }
        return msg
    }
    function checkName(){
        let value = bname.value
        let msg = ""
        if(!value){
            msg = "未添加姓名"
        }
        if(value.length > 8){
            msg = "姓名字符过长"
        }
        if(msg){
            alert(msg)
        }
        return msg
    }
</script>
</html>

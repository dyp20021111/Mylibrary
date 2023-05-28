<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>消息</title>
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/image/2.jpg");
            background-size: 100% 100%;
            width: 100%;
            height: 100%;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<div style="text-align: center; font-size: 40px; color: deepskyblue">
    <h1>
        ${msg}
    </h1>
</div>
<div style="text-align: center;color: deepskyblue ">
    <form style="position: relative; width: 80px; height: 50px; left: 47% " action="${pageContext.request.contextPath}/user/toindex" >
        <input type="submit" value="确定" style="width: 100%; height: 100%;color:darkblue">
    </form>
</div>
</body>
</html>


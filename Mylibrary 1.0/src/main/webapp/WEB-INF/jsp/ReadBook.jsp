<%--
  Created by IntelliJ IDEA.
  User: 邓佑朋DM
  Date: 2023/5/25
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书阅读</title>
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
<br><h1>推荐阅读书目一</h1> <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/tozhaohuaxishi">朝花夕拾</a>  <br>
<br><h1>推荐阅读书目二</h1> <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/tohongyan">红岩</a> <br>
</body>
</html>

<%@ page import="com.ssm.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<span style="color:red">当前时间：</span>

<html>
<head>
    <meta charset="UTF-8">
    <title>welcome to library</title>

    <script>
        function startTime(){
            var today=new Date();
            var h=today.getHours();
            var m=today.getMinutes();
            var s=today.getSeconds();// 在小于10的数字前加一个‘0’
            m=checkTime(m);
            s=checkTime(s);
            document.getElementById('txt').innerHTML=h+":"+m+":"+s;
            t=setTimeout(function(){startTime()},500);
        }
        function checkTime(i){
            if (i<10){
                i="0" + i;
            }
            return i;
        }
    </script>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        html,body{
            width: 100%;
            height: 100%;
        }
        p{
            font-family: STHUp;
            clear: both;
            text-align: center;
            font-size: 40px;
            font-weight: bold;
            color: darkorange;
        }
        button{
            margin-top: 150px;
            background-color: transparent;
        }
        .button1{
            float: left;
            margin-left: 33%;
        }
        .button2{
            float: right;
            margin-right: 33%;
        }
        .button3{
            float: right;
            margin-right: 33%;
        }
        .button4{
            float: left;
            margin-left: 33%;
        }
        a{
            text-decoration: none;
        }
        .a1{
            color: aquamarine;
        }
        .a2{
            color: darkorchid;
        }
        .a3{
            color: black;
        }
        body{
            background-image: url("${pageContext.request.contextPath}/image/2.png");
            background-size: 100% 100%;
            width: 100%;
            height: 100%;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body onload="startTime()">
<div id="txt"></div>
<div>
    <%-- 先取出用户登录信息 --%>
    <%
        User user = (User) session.getAttribute("login");
        request.setAttribute("user", user);
    %>
    <%-- 登录提示 --%>
    <% if (user == null){ %>
    <a href="${pageContext.request.contextPath}/user/toLogin" style="text-decoration:underline;"><p>请登录 </p></a>
    <% } else { %>
    <%-- 欢迎界面 --%>
    <p >您好, ${user.username},您可以进行以下操作 </p>

        <div class="row">
            <div class="col-md-4 column">
                <img src="${pageContext.request.contextPath}/image/9.png" ;width="30"; height="30"><a class="btn btn-primary" href="${pageContext.request.contextPath}/user/logout">退出登录</a>
                <img src="${pageContext.request.contextPath}/image/12.png" ;width="20"; height="25"><a class="btn btn-primary" href="${pageContext.request.contextPath}/user/Me">馆长介绍</a>
            </div>
        </div>
    <% } %>

    <%-- 任何人都可以查询图书信息 --%>

    <button class="button1">
        <a class="a1" href="${pageContext.request.contextPath}/book/listBooks"><h1>查询图书</h1></a>
    </button>
        <%--图书馆了解--%>
        <button class="button2">
            <a class="a2" href="${pageContext.request.contextPath}/user/readLibrary"><h1>图书馆详情</h1></a>
        </button>

    <%-- 管理员才可以添加图书 --%>
    <% if(user != null && user.getPermission() == 1) { %>
    <button class="button2">
        <a class="a2" href="${pageContext.request.contextPath}/book/toAddBook"><h1>添加图书</h1></a>
    </button>
        <%--管理员才可以查询用户信息--%>
        <button class="button1">
            <a class="a3" href="${pageContext.request.contextPath}/user/toUserList"><h1>查询用户</h1></a>
        </button>



    <% } else if (user != null && user.getPermission() == 2) {%>
    <%-- 用户才有我的借阅 --%>
    <button class="button2">
        <a class="a2" href="${pageContext.request.contextPath}/user/listUserBooks?userid=${sessionScope.get("login").userid}"><h1>我的借阅</h1></a>
    </button>
        <button class="button4">
            <a class="a2" href="${pageContext.request.contextPath}/user/toPreTable"><h1>座位预约</h1></a>
        </button>
        <button class="button4">
            <a class="a2" href="${pageContext.request.contextPath}/user/toConnection"><h1>联系我们</h1></a>
        </button>
        <button class="button2">
            <a class="a2" href="${pageContext.request.contextPath}/user/toQuickRead"><h1>快速阅读</h1></a>
        </button>

    <% } %>

        <input type="text" id="searchstr" name="searchstr" class="textbox" size="10">
        <a href="http://www.baidu.com/">全网搜索</a>
</div>


</body>
</html>

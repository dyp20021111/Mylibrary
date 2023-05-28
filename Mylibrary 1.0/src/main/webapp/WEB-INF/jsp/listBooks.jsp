<%@ page import="com.ssm.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<span style="color:red">当前时间：</span>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书列表</title>

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

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <style type="text/css">
        html,body{
            width: 100%;
            height: 100%;
        }
        body{
            background-image: url("${pageContext.request.contextPath}/image/6.png");
            background-size: 100% 100%;
            width: 100%;
            height: 100%;
            background-repeat: no-repeat;
        }
        table,th,td{
            border: 1px solid red ;
            border-collapse: collapse;
        }
    </style>
</head>
<body onload="startTime()">
<div id="txt"></div>
<%-- 先取出用户登录信息 --%>
<%
    User user = (User) session.getAttribute("login");
    request.setAttribute("user", user);
%>
<div class="container" style="width: 630px; position:relative; left: 30%; top: 5%; background-color: white">
    <input type="text" placeholder="请输入要查询的书名" id="book">
    <button class="btn">查询</button>
    <table class="tablelist">
        <thead>
        <tr>
            <th style="width: 50px; text-align: center">序号</th>
            <th style="width: 140px; text-align: center">书名</th>
            <th style="width: 50px; text-align: center">数量</th>
            <th style="width: 310px; text-align: center">描述</th>
            <th style="width: 100px;text-align: center">操作</th>
        </tr>
        </thead>
        <tbody>
        <%-- 先确定有书可展示 --%>
        <c:if test="${books != null}" >
            <c:forEach items="${books}" var="book" varStatus="st">
                <tr style="height: 35px">
                    <td align="center">${st.count}</td>
                    <td align="center">${book.bookname}</td>
                    <td align="center">${book.bookcount}</td>
                    <td align="center">${book.detail}</td>
                    <td align="center">
                            <%-- 对不登录、普通用户、管理员提供不同的操作 --%>
                        <% if (user == null) { %>
                        无操作
                        <% } else if (user.getPermission() == 2) { %>
                        <button onclick="borrowBook(${book.bookcount}, ${book.bookid}, ${user.userid})"><a class="btn btn-primary btn-xs">借书</a></button>
                        <% } else { %>
                        <button style="float: left"><a href="${pageContext.request.contextPath}/book/toUpdateBook/${book.bookid}" class="btn btn-primary btn-xs">修改</a></button>
                        <button style="float: right"><a href="${pageContext.request.contextPath}/book/delBook?bookid=${book.bookid}" class="btn btn-primary btn-xs">删除</a></button>
                        <% } %>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
<div class="row">
    <div class="col-md-4 column">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/toindex">返回主界面</a>
    </div>
</div>

<script type="text/javascript">
    //查询按钮
    $(".btn").on('click',()=>{
        var name=$('#book').val().trim()
        // console.log(name)
        window.location.href ="${pageContext.request.contextPath}/book/listBooks?bookname="+name;
    })





    // 借书用ajax传递json格式信息
    function borrowBook(bookcount, bookid, userid) {
        if (bookcount == 0){
            alert("无书可借");
            return;
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/book/borrowBook",
            type:"post",
            data:JSON.stringify({bookid:bookid, userid:userid}),
            contentType:"application/json;charset=UTF-8",
            success: function (data) {
                // 显示后端返回的结果
                alert(data.info);
                // 刷新本页面
                location.reload();
            }
        })
    }
</script >
</body>


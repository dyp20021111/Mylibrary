<%@ page import="com.ssm.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<span style="color:red">当前时间：</span>
<html>
<head>
  <meta charset="UTF-8">
  <title>我的借阅</title>
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
  <link rel="stylesheet" type="text/css" href="asserts/bootstrap/css/bootstrap.css" />
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
  <style type="text/css">
    html,body{
      width: 100%;
      height: 100%;
    }
    body{
      background-image: url("${pageContext.request.contextPath}/image/5.png");
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
<%-- 先取出用户登录信息，只有登录的用户能访问到这里 --%>
<%
  User user = (User) session.getAttribute("login");
  request.setAttribute("user", user);
%>
<h1 style="color: darkorange" align="center">${user.username}借阅的图书</h1>
<div class="container" style="width: 630px; position:relative; left: 50%; top: 10%; background-color: white">
  <table class="tablelist">
    <thead>
    <tr>
      <th style="width: 50px; text-align: center">序号</th>
      <th style="width: 140px; text-align: center">书名</th>
      <th style="width: 310px; text-align: center">描述</th>
      <th style="width: 100px;text-align: center">操作</th>
    </tr>
    </thead>
    <tbody>
    <%-- 先判断有没有借书 --%>
    <c:if test="${books != null}" >
      <c:forEach items="${books}" var="book" varStatus="st">
        <tr style="height: 35px">
          <td align="center">${st.count}</td>
          <td align="center">${book.bookname}</td>
          <td align="center">${book.detail}</td>
          <td align="center">
            <input type="button" style="border: 1px solid " onclick="returnBook(${book.bookid})" value="还书"/>
          </td>
        </tr>
      </c:forEach>
    </c:if>
    </tbody>
  </table>
  <jsp:include page="returnIndex.jsp" />
</div>

<script type="text/javascript">
  // 用ajax发送换书请求
  function returnBook(bookid) {
    var userid = ${user.userid};
    var bookid = bookid;
    $.ajax({
      url:"${pageContext.request.contextPath}/book/returnBook",
      type:"post",
      data:JSON.stringify({userid:userid,bookid:bookid}),
      contentType:"application/json;charset=UTF-8",
      success:function (data) {
        alert(data.info);
        location.reload();
      }
    });
  }
</script>
</body>
</html>

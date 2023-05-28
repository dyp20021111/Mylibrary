<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>用户列表</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- 引入 Bootstrap -->
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>

  <style>
    body{
      background-image: url("${pageContext.request.contextPath}/image/5.png");
      background-size: 100% 100%;
      width: 100%;
      height: 100%;
      background-repeat: no-repeat;
    }
  </style>
</head>
<body>

<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="page-header">
        <h1>
          <small>用户列表 —— 显示所有用户</small>
        </h1>
      </div>
    </div>
  </div>

   <tr>
  <div class="row">
    <div class="col-md-4 column">
      <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/toAddUser">新增用户</a>
    </div>
  </div>
   </tr>

  <tr>
  <div class="row">
    <div class="col-md-4 column">
      <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/toindex">返回主界面</a>
    </div>
  </div>
    <tr>

  <div class="row clearfix">
    <div class="col-md-12 column">
      <table class="table table-hover table-striped">
        <thead>
        <tr>
          <th>用户id</th>
          <th>用户名</th>
          <th>用户账号</th>
          <th>用户密码</th>
          <th>用户描述</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${user != null}" >
        <c:forEach items="${user}" var="user" varStatus="st">
          <tr>
            <td>${user.getUserid()}</td>
            <td>${user.getUsername()}</td>
            <td>${user.getAccount()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getDetail()}</td>
            <td>
              <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/toUpdateUser?userid=${user.getUserid()}">更改</a>
              <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/delUser/${user.getUserid()}">删除</a>
            </td>


          </tr>
        </c:forEach>
        </c:if>
        </tbody>



      </table>
    </div>
  </div>
</div>
</body>
</html>
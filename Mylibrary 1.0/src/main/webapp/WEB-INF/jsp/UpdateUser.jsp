<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>


    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/image/11.png");
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
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/user/updateUser" method="post">
        <input type="hidden" name="userid" value="${user.getUserid()}"/>
        用户名：<input type="text" name="username" value="${user.getUsername()}"/>
        用户账号：<input type="text" name="account" value="${user.getAccount()}"/>
        用户密码：<input type="text" name="password" value="${user.getPassword()}"/>
        用户描述：<input type="text" name="detail" value="${user.getDetail()}"/>
        <input type="submit" value="提交"/>
    </form>

</div>
</body>
</html>
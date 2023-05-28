<%--
  Created by IntelliJ IDEA.
  User: 邓佑朋DM
  Date: 2023/5/25
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <jsp:useBean id="date" class="java.util.Date" />
<span style="color:red">当前时间：</span>

<html>
<head>


    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>了解图书馆</title>

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
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/image/2.png");
            background-size: 100% 100%;
            width: 100%;
            height: 100%;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body  onload="startTime()">

<div id="txt"></div>
<br><a href="https://www.hnust.edu.cn">湖南科技大学</a> 图书馆由原湘潭工学院和原湘潭师范学院图书馆于2003年合并组建而成。</br>
<br>图书馆建筑面积35944平方米，其中南校区图书馆建筑面积为24855平方米，北</br>
<br>校区图书馆建筑面积为11089平方米。图书馆共设书库或阅览室33个，阅览席位3600多席，</br>
<br>其中电子阅览席位330席。图书馆设六部一室：办公室、采编部、息技术部流通一部、流通二部、</br>
<br>期刊一部、期刊二部，在编职工90人，其中具有硕士以上学位的12人，正高级职称人员2人，副高级职称人员20人。</br>
<br>图书馆全天开放。这是湖南科技大学图书馆的官网地址<a href="https://lib.hnust.edu.cn/">https://lib.hnust.edu.cn/</a>欢迎大家来学习交流！ <br>


<div class="row">
    <div class="col-md-4 column">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/toReadBook">推荐书目</a>
    </div>
</div>
<h3>科大宣传篇震撼来袭，最美校园湖科大</h3>
<embed src="https://www.bilibili.com/video/av754028183/?vd_source=50e1d200fc1e03a4c36313ea16a0ab40" width="1100" height="500">

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 邓佑朋DM
  Date: 2023/5/26
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>座位预约</title>

    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/image/13.png");
            background-size: 100% 100%;
            width: 100%;
            height: 100%;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<h2>线下图书馆座位预约规则</h2>
<br>1.<span style="color:red">预约开始时间</span>： 前一天的21:30，即每天闭馆前半小时可预约第二天座位。
<br>2.预约限制：每次预约时长最长4小时，每人同一时间仅可<span style="color:red">预约一个座位</span>。
<br>3.座位预留：20分钟，即预约成功后，必须在预约开始前后20分钟内签到。
<br>4.预约取消：读者提交预约后如临时不再使用该座位，可取消预约，每人每天至多取消预约3次。
<br>5.暂离座位：预约时长内，临时有事可暂离，<span style="color:red">最长可暂离20分钟</span>，20分钟内不返回座位，座位将被自动释放。
<br>6.监督座位：读者发现有座无人，可对座位进行监督，监督时长最长为20分钟，20分钟内预约人不返回座位，即监督有效，座位自动释放.
<br>7.座位续约：读者如需连续使用座位，可进行续约。离本次预约结束时间1小时内，方可续约。
<br>8.<span style="color:red">用餐时间</span>：每天11:30-13:00 和17:00-18:30，用餐时段内，可暂离90分钟。
<br> <span style="color:red">希望同学们遵守规则，做一个文明的好学生!</span>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 邓佑朋DM
  Date: 2023/5/26
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>红岩</title>
  <style>
    body{
      background-image: url("${pageContext.request.contextPath}/image/5.jpg");
      background-size: 100% 100%;
      width: 100%;
      height: 100%;
      background-repeat: no-repeat;
    }
  </style>
</head>
<body>
<h2>【名著导读】:《红岩》——有一种精神，在烈火中永生 </h2>
<h3>作者简介</h3>
<br>罗广斌、杨益言，他们都是重庆中美合作所集中营的幸存者，根据他们的亲身经历在1957年写出了</br>
<br>革命回忆录《烈火中永生》，随后在此基础上创作了长篇小说《红岩》。</br>
<h3>主要人物</h3>
<br>江姐，许云峰，刘思扬等</br>
<h3>艺术特色</h3>
<br>1、结构宏伟而严谨，错综复杂而有条不紊，是《红岩》一个显著的艺术特色。
<br>2 、此外，注重心理活动的描写和环境气氛的渲染，也是《红岩》的一个鲜明的艺术特色。
<h2>现实意义</h2>
<br>《红岩》是当代文学中一部优秀的革命英雄传奇，它真实记录了中国革命在即将取得胜利的历史关头时光明与黑暗的殊死斗争。
<br>书中众多英雄人物身上所表现出来的大无畏的牺牲精神和坚如磐石的理想与信念，以及他们在这最后的历史瞬间由光明和黑暗的
<br>殊死搏斗所激发出来的精神光焰，曾经震撼了许许多多青年读者的心，影响着他们的精神构成。坚定理想信念、崇高思想境界、
<br>巨大人格力量、浩然革命正气为主要内容的红岩精神，从本质上讲是信念与正气。红岩精神之所以影响深远，是因为在社会发展的
<br>过程中，每一个阶段、每个时期都离不开正确的、鼓舞志气的、人们都接受和认同的政治追求。



<div style="text-align: center">
  <form style="position: relative; width: 80px; height: 80px; left: 50%;margin-top: 100px" action="${pageContext.request.contextPath}/user/toReadBook" >
    <input type="submit" value="返回"  style="width: 100%; height: 100%">
  </form>
</div>
</body>
</html>

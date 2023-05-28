<%--
  Created by IntelliJ IDEA.
  User: 邓佑朋DM
  Date: 2023/5/25
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>朝花夕拾</title>
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/image/4.jpg");
            background-size: 100% 100%;
            width: 100%;
            height: 100%;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<h2>一、作者简介</h2>
<br>鲁迅（1881－1936），浙江绍兴人，原名周樟寿，后改名周树人，“鲁迅”是他1918年发表《狂人日记》时</br>
<br>所用的笔名。 著名文学家、思想家，<a href="https://zhidao.baidu.com/question/341831081.html">五四新文化运动</a>的重要参与者，中国现代文学的奠基人。毛泽东</br>
<br>评价：“鲁迅的方向，就是中华 民族新文化的方向。”</br>
<h2>二、写作背景</h2>
<br>1926年，北洋军阀政府枪杀进步学生，制造了“三·一八”惨案。作者鲁迅写下《纪念刘和珍君》等一系列文章，热情支</br>
<br>持学生的正义斗争，控诉北洋军阀政府的残暴。《朝花夕拾》中的作品虽然在追忆往事，但也是“借题发挥”，影射、讥讽</br>
<br>当时的社会现实</br>
<h2>三、故事梗概</h2>
<br>《朝花夕拾》为“回忆的记事”，反映了鲁迅青少年时期的生活。前七篇反映他童年在绍兴的家和私塾中的生活情景，</br>
<br>后三篇叙述他从家乡到南京，到日本留学，然后回国教书的经历。 作品揭露了半殖民地半封建社会的丑恶现象，反</br>
<br>映了那些有抱负的青年知识分子在旧中国茫茫黑夜中，不畏艰险，寻找光明的困难历程，以及抒发了作者对往日亲友、</br>
<br>师长的怀念之情。
<h2>四、主题思想</h2>
<br> ⑴具有强烈的反封建思想，具有对封建教育、封建道德、封建顽固派的批判意识。</br>
<br> ⑵表现对亲友和师长的崇敬、怀念之情。</br>
<br> ⑶批判封建思想、封建制度对青少年的毒害思想。</br>
<br> ⑷揭露思想文化战线上资产阶级文人的本质。</br>
<br> ⑸作者以炽烈的感情和浓重的笔墨，揭示了一个时代的各个侧面。</br>
<div style="text-align: center">
    <form style="position: relative; width: 80px; height: 80px; left: 50%;margin-top: 100px" action="${pageContext.request.contextPath}/user/toReadBook" >
        <input type="submit" value="返回"  style="width: 100%; height: 100%">
    </form>
</div>


</body>

</html>

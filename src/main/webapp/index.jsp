<%--
  Created by IntelliJ IDEA.
  model: HatsuneMona
  Date: 2020/3/23
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
  <link rel="stylesheet" type="text/css" href="resources/css/mainstyle.css">
  <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
  <script type="text/javascript" src="resources/js/mainjs.js"></script>
  <meta charset="UTF-8">
  <title>萌奈的作业</title>
</head>
<body onload="startTime()">
<table style="width: calc(100% - 1px);">
  <tr>
    <td colspan="2">
      <!--标题-->
      <div class="top">
        <h1>萌奈的教师管理系统</h1>
      </div>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <div style="height: 22px;
      text-align: right;
       background-color: #58C9B9;">
        <table style="float:right">
          <tr>
            
            <td style="width: 100px;">当前用户：</td>
            <td style="width: 200px; text-align: left">
              <%
                if (session.getAttribute("loginUser") == null) {
              %>未登录&nbsp;&nbsp;&nbsp; <a href="login.jsp">登录</a><%
            } else {
            %><%=session.getAttribute("loginUser")%>
              &nbsp;&nbsp;&nbsp;<a href="/SignOut?do=quit">退出登录</a>
              <%
                }
              %>
            </td>
            <td style="width: 100px">系统时间：</td>
            <td style="width: 260px; text-align: left" id="DateTime"></td>
          </tr>
        </table>
      </div>
    </td>
  </tr>
  <tr>
    <td style="height:300px; width: 181px">
      <!--左侧-->
      <div class="left">
        <ul class="container">
          <li>
            <button type="button" class="btn btn-primary"
                    onclick="document.getElementById('main_iframe').src='https://www.moeneko.top/'">
              萌奈的主页
            </button>
          </li>
          <%if (session.getAttribute("loginUser") == null) {%>
          <li>
            <button type="button" class="btn btn-primary"
                    onclick="window.location.href='login.jsp'">
              登陆
            </button>
          </li>
          <%}%>
          <%if (session.getAttribute("loginUser") != null) {%>
          <li>
            <button type="button" class="btn btn-primary"
                    onclick="document.getElementById('main_iframe').src='/RegPages/userReg.jsp'">
              注册新用户
            </button>
          </li>
          <li>
            <button type="button" class="btn btn-primary"
                    onclick="document.getElementById('main_iframe').src='./RegPages/teacherReg.jsp'">
              录入新教师
            </button>
          </li>
          <li>
            <button type="button" class="btn btn-primary"
                    onclick="document.getElementById('main_iframe').src='./RegPages/deptReg.jsp'">
              添加/查询系部
            </button>
          </li>
          <li>
            <button type="button" class="btn btn-primary"
                    onclick="document.getElementById('main_iframe').src='/QueryPages/teacherQue.jsp'">
              教师查询
            </button>
          </li>
          <%}%>
          <li>
            <button type="button" class="btn btn-primary"
                    onclick="javascript:document.getElementById('main_iframe').src='./OtherPages/Calculation.jsp'">
              社保计算
            </button>
          </li>
        </ul>
      </div>
    </td>
    <td>
      <!--主要-->
      <iframe class="main_iframe" id="main_iframe" src="https://www.moeneko.top/"></iframe>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <!--底部-->
      <div class="bottom">
        <p>Copyright &copy; by HatsuneMona All Rights Reserved.</p>
        <p><a href="https://gitee.com/HatsuneMona/JavaWeb_Study">源代码（Github）</a>
          &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
          <a href="https://gitee.com/HatsuneMona/JavaWeb_Study">源代码（Gitee镜像）</a>
        </p>
        <p><a href="http://www.beian.miit.gov.cn">晋ICP备17007130号-3</a></p>
      </div>
    </td>
  </tr>
</table>

<script language="JavaScript">
  function startTime() {
    var today = new Date();//定义日期对象
    var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年
    var MM = today.getMonth() + 1;//通过日期对象的getMonth()方法返回年
    var dd = today.getDate();//通过日期对象的getDate()方法返回年
    var hh = today.getHours();//通过日期对象的getHours方法返回小时
    var mm = today.getMinutes();//通过日期对象的getMinutes方法返回分钟
    var ss = today.getSeconds();//通过日期对象的getSeconds方法返回秒
    // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09
    MM = checkTime(MM);
    dd = checkTime(dd);
    mm = checkTime(mm);
    ss = checkTime(ss);
    var day; //用于保存星期（getDay()方法得到星期编号）
    if (today.getDay() == 0) day = "星期日 "
    if (today.getDay() == 1) day = "星期一 "
    if (today.getDay() == 2) day = "星期二 "
    if (today.getDay() == 3) day = "星期三 "
    if (today.getDay() == 4) day = "星期四 "
    if (today.getDay() == 5) day = "星期五 "
    if (today.getDay() == 6) day = "星期六 "
    document.getElementById('DateTime').innerHTML = yyyy + "-" + MM + "-" + dd + " " + hh + ":" + mm
        + ":" + ss + "   " + day;
    setTimeout('startTime()', 1000);//每一秒中重新加载startTime()方法
  }

  function checkTime(i) {
    if (i < 10) {
      i = "0" + i;
    }
    return i;
  }
</script>
</body>
</html>

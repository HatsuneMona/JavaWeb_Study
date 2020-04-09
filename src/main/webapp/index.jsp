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
<body>
<table style="width: calc(100% - 1px);">
  <tr>
    <td colspan="2">
      <!--标题-->
      <div class="top">
        <h1>欢迎光临</h1>
      </div>
    </td>
  </tr>
  <tr>
    <td style="height:300px; width: 181px">
      <!--左侧-->
      <div class="left">
        <ul>
          <li>
            <button type="button" class="btn btn-primary" onclick="showmain()">萌奈的主页
            </button>
          </li>
          <li>
            <button type="button" class="btn btn-primary" onclick="showshebao()">社保计算
            </button>
          </li>
          <li>
            <button type="button" class="btn btn-primary" onclick="showlogin()">登陆
            </button>
          </li>
          <li>
            <button type="button" class="btn btn-primary" onclick="showReg()">录入新教师
            </button>
          </li>
        </ul>
      </div>
    </td>
    <td>
      <!--主要-->
      <div class="main_div">
        <!--    <iframe src="Calculation.jsp" class="main_iframe">    </iframe>-->
        <iframe class="main_iframe" id="main_iframe" src="https://www.baidu.com"></iframe>
      </div>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <!--底部-->
      <div class="bottom">
        <p>Copyright &copy; by HatsuneMona All Rights Reserved.</p>
        <!--                <p>太原工业学院 172054213 宋海禹</p>-->
        <p><a href="http://www.beian.miit.gov.cn">晋ICP备17007130号-3</a></p>
      </div>
    </td>
  </tr>
</table>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn" class="no-js">
<head>
  <meta charset="UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>login</title>
  <link rel="stylesheet" type="text/css" href="resources/LoginPage/css/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="resources/LoginPage/css/demo.css"/>
  <!--必要样式-->
  <link rel="stylesheet" type="text/css" href="resources/LoginPage/css/component.css"/>
  <!--[if IE]>
  <script src="resources/LoginPage/js/html5.js"></script>
  <![endif]-->
</head>
<body>
<div class="container demo-1">
  <div class="content">
    <div id="large-header" class="large-header">
      <canvas id="demo-canvas"></canvas>
      <div class="logo_box">
        <h3>萌奈的教师管理系统</h3>
        <form action="/LoginServlet" name="loginform" id="loginform" method="post">
          <div class="input_outer">
            <span class="u_user"></span>
            <input name="logname" class="text" style="color: #FFFFFF !important" type="text"
                   placeholder="请输入账户">
          </div>
          <div class="input_outer">
            <span class="us_uer"></span>
            <input name="logpass" class="text"
                   style="color: #FFFFFF !important; position:absolute; z-index:100;" value=""
                   type="password" placeholder="请输入密码">
          </div>
          <div class="mb2"><a class="act-but submit" href="javascript:loginform.submit();"
                              style="color: #FFFFFF">登录</a></div>
        </form>
      </div>
    </div>
  </div>
</div><!-- /container -->
<script src="resources/LoginPage/js/TweenLite.min.js"></script>
<script src="resources/LoginPage/js/EasePack.min.js"></script>
<script src="resources/LoginPage/js/rAF.js"></script>
<script src="resources/LoginPage/js/demo-1.js"></script>
</body>
</html>
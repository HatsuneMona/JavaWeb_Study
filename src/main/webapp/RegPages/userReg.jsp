<%--
  Created by IntelliJ IDEA.
  model: HatsuneMona
  Date: 2020/3/23
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
  <meta charset="UTF-8">
  <title>教师注册</title>
  <!--    <link rel="icon" href="" type="image/x-iron">-->
  <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js"
          integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
          integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
          integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
          crossorigin="anonymous"></script>
  <link rel="stylesheet" href="../resources/css/stureg.css" type="text/css">

</head>
<body>
<div class="text-center">
  <h3>新用户注册</h3>
</div>
<div class="regmain container"> <!--后者居中-->
  <form action="/UserReg" method="post">
    <table class="table table-bordered">
      <tr>
        <td class="bg-primary text-center" style="max-width: 150px;">用户名：</td>
        <td><input type="text" id="username" name="username"
                   class="form-control" onblur="checkUsername()"
                   placeholder="请输入用户名。以字母开头，字母与数字的组合，3-10字符">
        </td>
      </tr>
      <tr>
        <td class="bg-primary text-center">手机号：</td>
        <td><input type="text" id="phonenum" name="phonenum"
                   class="form-control" onblur="checkPhoneNum()"
                   placeholder="请输入大陆手机号"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">性别：</td>
        <td>
          <label class="radio-inline" for="male">
            <input class="radio" onblur="checksex()"
                   type="radio" id="male" name="sex"
                   value="male">男
          </label>
          <label class="radio-inline" for="female">
            <input class="radio" onblur="checksex()"
                   type="radio" id="female" name="sex"
                   value="female">女
          </label>
          <label class="radio-inline" for="other">
            <input class="radio" onblur="checksex()"
                   type="radio" id="other" name="sex"
                   value="other">其他
          </label>
        </td>
      </tr>
      <tr>
        <td class="bg-primary text-center">系部：</td>
        <td><input type="text" onblur="checkDept()"
                   id="dept" name="dept"
                   class="form-control" placeholder="请输入系部"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">真实姓名：</td>
        <td><input type="text" onblur="checkRealname()"
                   id="realname" name="realname"
                   class="form-control" placeholder="请输入真实姓名"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">密码：</td>
        <td><input type="password" onblur="checkPassword1()"
                   id="password1" name="password1"
                   class="form-control" placeholder="请输入密码，8-12位字母数字"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">确认密码：</td>
        <td><input type="password" onblur="checkPassword2()"
                   id="password2" name="password2"
                   class="form-control" placeholder="请再次输入密码"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">学校：</td>
        <td>
          <select class="form-control" id="school" name="school">
            <option>太原工业学院</option>
            <option>其他</option>
          </select>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" onclick="return checkAll()"
                 value="注册" class="btn btn-danger btn-block">
        </td>
      </tr>
    </table>
  </form>
</div>

<script src="../resources/js/userReg.js"></script>
</body>
</html>
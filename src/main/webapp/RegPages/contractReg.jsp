<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
  <meta charset="UTF-8">
  <title>合同添加</title>
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
  <h3>律师事务所 - 合同添加</h3>
</div>

<%
  try {
    if (Objects.equals(request.getParameter("status"), "OK")) {
%>
<div id="OKAlert" name="OKAlert" class="alert alert-warning">
  <a href="#" class="close" data-dismiss="alert">&times;</a>
  <strong>成功！</strong>编号为 ${param.tno} 的教师已添加。
</div>
<script>
  $(function () {
        $("#OKAlert").alert();
      }
  );
</script>
<%
} else if (Objects.equals(request.getParameter("status"), "Fail")) {
%>
<div id="FailAlert" name="FailAlert" class="alert alert-danger">
  <a href="#" class="close" data-dismiss="alert">&times;</a>
  <strong>错误！</strong>添加失败。（请检查信息填写是否正确）
</div>
<script>
  $(function () {
        $("#FailAlert").alert();
      }
  );
</script>
<%
    }
  } catch (Exception e) {
  }
%>
<div class="regmain container"> <!--居中-->
  
  <form action="/TeacherReg" method="post">
    <table class="table table-bordered">
      <tr>
        <td class="bg-primary text-center" style="max-width: 150px;">合同编号</td>
        <td><input type="text" id="teacherNo" name="teacherNo"
                   class="form-control" onblur="checkTeacherNo()"
                   placeholder="请输入教职工编号">
        </td>
      </tr>
      <tr>
        <td class="bg-primary text-center">合同类型</td>
        <td><input type="text" id="teacherName" name="teacherName"
                   class="form-control" onblur="checkTeacherName()"
                   placeholder="请输入教师姓名"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">领取日期</td>
        <td><input type="text" onblur="checkTeacherAge()"
                   id="teacherAge" name="teacherAge"
                   class="form-control" placeholder="请输入教师工龄"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">领取人</td>
        <td><input type="text" onblur="checkTeacherDept()"
                   id="teacherDept" name="teacherDept"
                   class="form-control" placeholder="请输入系部编号"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">经办人</td>
        <td>
          <label class="radio-inline" for="male">
            <input class="radio" onblur="checksex()"
                   type="radio" id="male" name="sex"
                   value="男">男
          </label>
          <label class="radio-inline" for="female">
            <input class="radio" onblur="checksex()"
                   type="radio" id="female" name="sex"
                   value="女">女
          </label>
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
<script src="../resources/js/teacherreg.js"></script>
<script>

</script>
</body>
</html>
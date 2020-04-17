<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,DAO.TeacherDao,model.TeachersinfoEntity" %>
<%@ page import="DAO.DepartmentDao" %>
<%
  Integer tno = null;
  try {
    tno = Integer.parseInt(request.getParameter("choosetno"));
  } catch (NumberFormatException e) {
    e.printStackTrace();
  }
  TeachersinfoEntity teacherInfo = TeacherDao.SearchTeacher(tno).get(0);
  String maleChecked = "";
  String femaleChecked = "";
  if (Objects.equals(teacherInfo.getTeacherSex(), "男")) {
    maleChecked = " checked=\"checked\"";
  } else {
    femaleChecked = " checked=\"checked\"";
  }
%>
<html lang="zh-cn">
<head>
  <meta charset="UTF-8">
  <title>教师信息修改</title>
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
  <h3>教职工信息修改</h3>
</div>
<%
  try {
    if (Objects.equals(request.getParameter("status"), "OK")) {
%>
<div id="StatusAlert" name="StatusAlert" class="alert alert-warning">
  <a href="#" class="close" data-dismiss="alert">&times;</a>
  <strong>成功！</strong>编号为 ${param.choosetno} 的教师已修改。
</div>
<script>
  $(function () {
        $("#StatusAlert").alert();
      }
  );
</script>
<%
    }
  } catch (Exception e) {
  }
%>
<div class="regmain container"> <!--后者居中-->
  <form action="/ModifyTeacherServlet" method="post">
    <table class="table table-bordered">
      <tr>
        <td class="bg-primary text-center" style="max-width: 150px;">教职工编号：</td>
        <td><input type="text" id="teacherNo" name="teacherNo"
                   class="form-control" onblur="checkTeacherNo()" readonly="readonly"
                   placeholder="请输入教职工编号" value="<%=teacherInfo.getTeacherNo()%>">
        </td>
      </tr>
      <tr>
        <td class="bg-primary text-center">教职工姓名：</td>
        <td><input type="text" id="teacherName" name="teacherName"
                   class="form-control" onblur="checkTeacherName()"
                   placeholder="请输入教师姓名" value="<%=teacherInfo.getTeacherName()%>"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">工龄：</td>
        <td><input type="text" onblur="checkTeacherAge()"
                   id="teacherAge" name="teacherAge"
                   class="form-control" placeholder="请输入教师工龄"
                   value="<%=teacherInfo.getTeacherAge()%>"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">任职系部：</td>
        <td><input type="text" onblur="checkTeacherDept()"
                   id="teacherDept" name="teacherDept"
                   class="form-control" placeholder="请输入系部编号"
                   value="<%=teacherInfo.getTeacherDepartment()%>"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">性别：</td>
        <td>
          <label class="radio-inline" for="male">
            <input class="radio" onblur="checksex()"
                   type="radio" id="male" name="sex" <%=maleChecked%>
                   value="男">男
          </label>
          <label class="radio-inline" for="female">
            <input class="radio" onblur="checksex()"
                   type="radio" id="female" name="sex" <%=femaleChecked%>
                   value="女">女
          </label>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" onclick="return checkAll()"
                 value="修改" class="btn btn-danger btn-block">
        </td>
      </tr>
    </table>
  </form>
</div>
<script src="../resources/js/teacherreg.js"></script>
</body>
</html>
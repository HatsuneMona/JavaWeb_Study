<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,DAO.TeacherDao,model.TeachersinfoEntity" %>
<%@ page import="DAO.DepartmentDao" %>

<html lang="zh-cn">
<head>
  <meta charset="UTF-8">
  <title>教师查询</title>
  <title>教职工注销</title>
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
  <link rel="stylesheet" href="../resources/css/mainStyleShell.css" type="text/css">
</head>
<body>
<div class="text-center">
  <h3>教职工查询</h3>
</div>
<div class="regmain container">
  <form action="./teacherQue.jsp" method="get">
    <table class="table table-bordered">
      <tr>
        <td class="bg-primary text-center" style="max-width: 150px;">教职工编号：</td>
        <td><input type="text" id="teacherNo" name="teacherNo"
                   value="${param.teacherNo}"
                   class="form-control"
                   placeholder="请输入教职工编号，留空查询全部">
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit"
                 value="查询" class="btn btn-danger btn-block"
                 id="submitBtn" name="submitBtn">
        </td>
      </tr>
    </table>
  </form>
</div>
<div class="regmain container">
  <form action="./teacherQue.jsp" method="post">
    <table class="table table-bordered  table-striped table-hover" style="text-align: center;">
      <tr>
        <td class="bg-primary text-center" style="max-width: 30px;">教职工编号</td>
        <td class="bg-primary text-center" style="max-width: 30px;">姓名</td>
        <td class="bg-primary text-center" style="max-width: 30px;">教龄</td>
        <td class="bg-primary text-center" style="max-width: 30px;">性别</td>
        <td class="bg-primary text-center" style="max-width: 30px;">系部</td>
        <td class="bg-primary text-center" style="max-width: 30px;">选择</td>
      </tr>
      <!--    TODO 用jsp加个循环-->
      <%
        Integer no = null;
        try {
          if (request.getParameter("teacherNo") != null) {
            no = Integer.parseInt(request.getParameter("teacherNo"));
          }
        } catch (Exception e) {
        
        }
        ArrayList<TeachersinfoEntity> tlist = TeacherDao.SearchTeacher(no);
        if (tlist.size() != 0) {
          for (TeachersinfoEntity i : tlist) {
      %>
      <tr>
        <td>
          <%=i.getTeacherNo()%><!--教职工编号-->
        </td>
        <td>
          <%=i.getTeacherName()%><!--姓名-->
        </td>
        <td>
          <%=i.getTeacherAge()%><!--教龄-->
        </td>
        <td>
          <%=i.getTeacherSex()%><!--性别-->
        </td>
        <td>
          <%=DepartmentDao.SearchDept(i.getTeacherDepartment()).get(0).getDepartmentName()%><!--系部-->
        </td>
        <td><label><input type="radio" name="tno" value="<%=i.getTeacherNo()%>"/></label></td>
        <!--选择框-->
      </tr>
      <%
        }
      } else {
      %>
      <td colspan="6">未能查询到数据。${param.teacherNo}</td><!--教职工编号-->
      <%
        }
      %>
    </table>
    
    <table class="table table-hover">
      <tr>
        <td style="width: 50%;"></td>
        <td style="width: 20%;">
          <a><button value="修改" class="btn btn-warning btn-block"
                     id="ModBtn" name="ModBtn"
                     onclick="javascript:window.location.href=
                     '../RegPages/teacherReg.jsp'">
            修改</button> </a>
        </td>
        <td style="width: 5%"></td>
        <td style="width: 20%;">
          <input type="submit"
                 value="删除" class="btn btn-danger btn-block"
                 id="DelBtn" name="DelBtn">
        </td>
      </tr>
    </table>
  
  </form>
</div>
<%
  int delete;
  try {
    if (request.getParameter("tno") != null) {
      delete = Integer.parseInt(request.getParameter("tno"));
      if (TeacherDao.DeleteTeacher(delete) == 1) {
%>
<div id="DeleteAlert" class="alert alert-warning">
  <a href="#" class="close" data-dismiss="alert">&times;</a>
  <strong>成功！</strong>编号为 ${param.delete} 的教师已被删除。
</div>
<script>
  $(function () {
        $("#DeleteAlert").alert();
        window.navigate("./teacherQue.jsp");
      }
  );
</script>
<%
      }
    }
  } catch (Exception e) {
  
  }
%>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="DAO.DepartmentDao, model.DepartmentsinfoEntity, java.util.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DAO.TeacherDao" %>
<html lang="zh-cn">
<head>
  <meta charset="UTF-8">
  <title>系部注册</title>
  <!--  <link rel="icon" href="/img/aaa.png" type="image/x-iron">-->
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
<div class="container">
  <table style="width: 99%;">
    <tr>
      <td valign="top">
        <div><br><br></div>
        <div class="text-center">
          <h3>系部注册</h3>
        </div>
        <div>
          <form action="/DeptReg" method="post">
            <table class="table table-bordered">
              <tr>
                <td class="bg-primary text-center" style="width: 180px;">系部编号：</td>
                <td><input type="text" id="deptNo" name="deptNo"
                           class="form-control" onblur="checkDeptNo()"
                           placeholder="请输入系部编号">
                </td>
              </tr>
              <tr>
                <td class="bg-primary text-center">系部名：</td>
                <td><input type="text" id="deptName" name="deptName"
                           class="form-control" onblur="checkDeptName()"
                           placeholder="系部名称"></td>
              </tr>
              
              <tr>
                <td class="bg-primary text-center">系部主任：</td>
                <td><input type="text" onblur="checkDeptHeader()"
                           id="deptHeader" name="deptHeader"
                           class="form-control" placeholder="请输入系部主任教师编号"></td>
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
      </td>
      <td style="width: 30px">
        <%--占位--%>
      </td>
      <td>
        <div>
          <form action="./deptReg.jsp" method="post">
            <table class="table table-bordered  table-striped table-hover"
                   style="text-align: center;">
              <tr>
                <td class="bg-primary text-center" style="max-width: 180px;">系部编号</td>
                <td class="bg-primary text-center" style="max-width: 200px;">名称</td>
                <td class="bg-primary text-center" style="max-width: 180px;">系领导名字</td>
                <td class="bg-primary text-center" style="max-width: 30px;">选择</td>
              </tr>
              <%
                ArrayList<DepartmentsinfoEntity> tlist = DepartmentDao.SearchDept(null);
                if (tlist.size() != 0) {
                  for (DepartmentsinfoEntity i : tlist) {
              %>
              <tr>
                <td>
                  <%=i.getDepartmentNo()%><!--系部编号-->
                </td>
                <td>
                  <%=i.getDepartmentName()%><!--系部名称-->
                </td>
                <td>
                  <%
                    String deptHeaderName = null;
                    try {
                      deptHeaderName = TeacherDao.SearchTeacher(i.getDepartmentHead()).get(0)
                          .getTeacherName();
                    } catch (Exception e) {
                      e.printStackTrace();
                    }
                    if (deptHeaderName != null) {%>
                  <%=deptHeaderName%><!--系领导名字-->
                  <%} else {%>
                  查无此人
                  <%}%>
                
                </td>
                
                <td><label><input type="radio" name="dno" value="<%=i.getDepartmentNo()%>"/></label>
                </td>
                <!--选择框-->
              </tr>
              <%
                }
              } else {
              %>
              <td colspan="4">未能查询到数据。</td>
              <%
                }
              %>
            </table>
            
            <table class="table table-hover">
              <tr>
                <td style="width: 50%;"></td>
                <td style="width: 20%;">
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
            if (request.getParameter("dno") != null) {
              delete = Integer.parseInt(request.getParameter("dno"));
              if (DepartmentDao.DeleteDept(delete) == 1) {
        %>
        <div id="DeleteAlert" class="alert alert-warning">
          <a href="#" class="close" data-dismiss="alert">&times;</a>
          <strong>成功！</strong>编号为 ${param.dno} 的系部已被删除。
        </div>
        <%
              }
            }
          } catch (NumberFormatException e) {
            e.printStackTrace();
          }
        %>
      </td>
    </tr>
  </table>
</div>


<script src="../resources/js/deptreg.js"></script>
</body>
</html>
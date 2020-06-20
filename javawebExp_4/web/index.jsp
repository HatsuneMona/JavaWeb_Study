<%@ page import="Model.UsersModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DAO.UserDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HatsuneMona
  Date: 2020/6/14
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>用户注册/修改/删除</title>
</head>
<body>
<div>
  <h1>用户注册</h1>
  <form action="/Reg" method="post">
    <table>
      <tr>
        <td>用户ID：</td>
        <td><input type="text" id="uid" name="uid"></td>
      </tr>
      <tr>
        <td>用户名：</td>
        <td><input type="text" id="uname" name="uname"></td>
      </tr>
      <tr>
        <td>用户密码：</td>
        <td><input type="password" id="upw" name="upw"></td>
      </tr>
      <tr>
        <td>用户类型：</td>
        <td><input type="text" id="urole" name="urole"></td>
      </tr>
      <tr>
        <td rowspan="2">
          <input type="submit">
        </td>
      </tr>
    </table>
  </form>
</div>
<div>
  <h1>用户列表</h1>
  <table>
    <tr>
      <td style="min-width: 100px;">用户id</td>
      <td style="min-width: 100px;">用户名</td>
      <td style="min-width: 100px;">用户密码</td>
      <td style="min-width: 100px;">用户角色</td>
    </tr>
    <%
      List<UsersModel> ulist = UserDAO.getAllUsers();
      if (ulist.size() != 0) {
        for (UsersModel i : ulist) {
    %>
    <tr>
      <td>
        <%=i.getUserid()%><!--编号-->
      </td>
      <td>
        <%=i.getUsername()%><!--姓名-->
      </td>
      <td>
        ************<!--密码-->
      </td>
      <td>
        <%=i.getUserrole()%><!--性别-->
      </td>
    </tr>
    <%
      }
    } else {
    %>
    <td colspan="4">未能查询到数据。</td><!--教职工编号-->
    <%
      }
    %>
  </table>
</div>
<div>
  <h1>用户删除</h1>
  <form action="/Del" method="post" name="delform" id="delform">
    <table>
      <tr>
        <td>请输入要删除的用户id：</td>
        <td><input type="text" id="did" name="did"></td>
        <td>
          <input type="submit">
        </td>
      </tr>
    </table>
  </form>
</div>
<div>
  <h1>用户修改</h1>
  <form action="/Update" method="post">
    <table>
      <tr>
        <td>要修改的用户ID：</td>
        <td><input type="text" id="uuid" name="uuid"></td>
      </tr>
      <tr>
        <td>修改后的用户名：</td>
        <td><input type="text" id="uuname" name="uuname"></td>
      </tr>
      <tr>
        <td>修改后的用户密码：</td>
        <td><input type="password" id="uupw" name="uupw"></td>
      </tr>
      <tr>
        <td>修改后的用户类型：</td>
        <td><input type="text" id="uurole" name="uurole"></td>
      </tr>
      <tr>
        <td rowspan="2">
          <input type="submit">
        </td>
      </tr>
    </table>
  </form>
</div>
<script>
  function deleteSubmit() {
    delform.action = "/Del";
    delform.submit();
  }
</script>
</body>
</html>

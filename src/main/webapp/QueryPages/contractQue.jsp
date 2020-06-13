<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,DAO.TeacherDao,model.TeachersinfoEntity" %>
<%@ page import="DAO.DepartmentDao" %>
<%@ page import="model.ContractEntity" %>
<%@ page import="DAO.ContractDao" %>

<html lang="zh-cn">
<head>
  <meta charset="UTF-8">
  <title>合同查询 - 律师事务所合同管理系统</title>
  <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
  <link rel="stylesheet" href="../resources/css/mainStyleShell.css" type="text/css">
</head>
<body>
<div class="text-center">
  <h3>教职工查询</h3>
</div>
<%
  try {
    if (Objects.equals(request.getParameter("status"), "DeleteOK")) {
%>
<div id="DeleteAlert" name="DeleteAlert" class="alert alert-warning">
  <a href="#" class="close" data-dismiss="alert">&times;</a>
  <strong>成功！</strong>编号为 ${param.cid} 的合同已被删除。<%--TODO 这里的cid--%>
</div>
<script>
  $(function () {
        $("#DeleteAlert").alert();
      }
  );
</script>
<%
    }
  } catch (Exception e) {
  }
%>
<div class="regmain container">
  <form action="./contractQue.jsp" method="get">
    <table class="table table-bordered">
      <tr>
        <td class="bg-primary text-center" style="max-width: 150px;">合同编号：</td>
        <td><input type="text" id="contractid" name="contractid"
                   value="${param.contractid}"
                   class="form-control"
                   placeholder="请输入合同编号，留空查询全部">
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
  <form action="" id="queform" name="queform" method="post">
    <table class="table table-bordered  table-striped table-hover" style="text-align: center;">
      <tr>
        <td class="bg-primary text-center" style="max-width: 30px;">合同编号</td>
        <td class="bg-primary text-center" style="max-width: 30px;">合同类型</td>
        <td class="bg-primary text-center" style="max-width: 30px;">领取日期</td>
        <td class="bg-primary text-center" style="max-width: 30px;">领取人</td>
        <td class="bg-primary text-center" style="max-width: 30px;">经办人</td>
        <td class="bg-primary text-center" style="max-width: 130px;">备注</td>
        <td class="bg-primary text-center" style="max-width: 30px;">选择</td>
      </tr>
      <%
        String id = null;
        try {
          if (request.getParameter("contractid") != null) {
            id = request.getParameter("contractid");
          }
        } catch (Exception e) {
    
        }
        ArrayList<ContractEntity> clist = ContractDao.SearchContract(id);
        if (clist.size() != 0) {
          for (ContractEntity i : clist) {
      %>
      <tr>
        <td>
          <%=i.getContractid()%><!--合同编号-->
        </td>
        <td>
          <%=i.getContracttype()%><!--合同类型-->
        </td>
        <td>
          <%=i.getGatdate()%><!--领取日期-->
        </td>
        <td>
          <%=i.getLawer()%><!--领取人-->
        </td>
        <td>
          <%=i.getOperator()%><!--经办人-->
        </td>
        <td>
          <%=i.getRemark()%><!--备注-->
        </td>
        <td><label><input type="radio" name="chooseid" id="chooseid"
                          value="<%=i.getContractid()%>"/></label></td>
        <!--选择框-->
      </tr>
      <%
        }
      } else {
      %>
      <td colspan="6">未能查询到数据。${param.contractid}</td><!--教职工编号-->
      <%
        }
      %>
    </table>
    
    <table class="table table-hover">
      <tr>
        <td style="width: 50%;"></td>
        <td style="width: 20%;">
          <%--          <a>--%>
          <%--            <button value="修改" class="btn btn-warning btn-block"--%>
          <%--                    id="ModBtn" name="ModBtn"--%>
          <%--                    onclick="modifySubmit()">--%>
          <%--              修改--%>
          <%--            </button>--%>
          <%--          </a>--%>
        
        </td>
        <td style="width: 5%"></td>
        <td style="width: 20%;">
          <a>
            <button value="删除" class="btn btn-danger btn-block"
                    id="DelBtn" name="DelBtn"
                    onclick="deleteSubmit()">
              删除
            </button>
          </a>
          <%--          <input type="submit"
                           value="删除" class="btn btn-danger btn-block"
                           id="DelBtn" name="DelBtn">--%>
        </td>
      </tr>
    </table>

  </form>
</div>

<script>
  function deleteSubmit() {
    queform.action = "/contractDel";
    queform.submit();
  }

  // function modifySubmit() {
  //   queform.action = "/ModifyPages/contractModify.jsp";
  //   queform.submit();
  // }
</script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
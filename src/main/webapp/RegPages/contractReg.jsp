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
<body onload="startTime()">
<div class="text-center">
  <h3>律师事务所 - 合同添加</h3>
</div>

<%
  try {
    if (Objects.equals(request.getParameter("status"), "OK")) {
%>
<div id="OKAlert" name="OKAlert" class="alert alert-warning">
  <a href="#" class="close" data-dismiss="alert">&times;</a>
  <strong>成功！</strong>编号为 ${param.tno} 的合同已添加。
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
  
  <form action="/ContractReg" method="post">
    <table class="table table-bordered">
      <tr>
        <td class="bg-primary text-center" style="max-width: 150px;">合同编号</td>
        <td><input type="text" id="contractid" name="contractid"
                   class="form-control"
                   placeholder="请输入合同编号">
        </td>
      </tr>
      <tr>
        <td class="bg-primary text-center">合同类型</td>
        <td>
          <select class="form-control" id="contracttype" name="contracttype">
            <option>民事诉讼</option>
            <option>刑事诉讼</option>
            <option>行政诉讼</option>
          </select>
        </td>
      </tr>
      <tr>
        <td class="bg-primary text-center">领取日期</td>
        <td><input type="text" onclick="startTime()"
                   id="getdate" name="getdate"
                   class="form-control" value="现在"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">领取人</td>
        <td><input type="text"
                   id="lawer" name="lawer"
                   class="form-control" placeholder="请输入领取人"></td>
      </tr>
      <tr>
        <td class="bg-primary text-center">经办人</td>
        <td>
          <input type="text"
                 id="operator" name="operator"
                 class="form-control" placeholder="请输入经办人"></td>
        </td>
      </tr>
      <tr>
        <td class="bg-primary text-center">备注</td>
        <td>
          <input type="text"
                 id="remark" name="remark"
                 class="form-control" placeholder=""></td>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit"
                 value="添加" class="btn btn-danger btn-block">
        </td>
      </tr>
    </table>
  </form>
</div>
<script language="JavaScript">
  function startTime() {
    var today = new Date();//定义日期对象
    var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年
    var MM = today.getMonth() + 1;//通过日期对象的getMonth()方法返回年
    var dd = today.getDate();//通过日期对象的getDate()方法返回年
    var hh = today.getHours();//通过日期对象的getHours方法返回小时
    var mm = today.getMinutes();//通过日期对象的getMinutes方法返回分钟
    // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09
    MM = checkTime(MM);
    dd = checkTime(dd);
    mm = checkTime(mm);
    var text = yyyy + "-" + MM + "-" + dd + " " + hh + ":" + mm
    document.getElementById('getdate').value = text;
    setTimeout('startTime()', 60000);//每60秒中重新加载startTime()方法
    return text;
  }

</script>
</body>
</html>
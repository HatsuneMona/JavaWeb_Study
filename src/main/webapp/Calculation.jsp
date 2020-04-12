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
  <meta charset="UTF-8">
  <link rel="stylesheet" href="resources/css/calcstyle.css">
  <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
  <title>社保计算</title>
</head>
<body>
<table>
  <tr>
    <td>
      <div style="text-align: center">
        <h3>计算题</h3>
      </div>
    </td>
  </tr>
  <tr>
    <td>
      <div class="calc_div">
        <form id="shebao_form">
          <table class="table-bordered table-striped table-hover my-table">
            <tr>
              <td>工资</td>
              <td colspan="3">
                <input type="number" id="money"> 元
              </td>
              <td>
                <button type="button" onclick="calculation()">计算</button>
              </td>
            </tr>
            <tr>
              <td>险种</td>
              <td>个人比例 %</td>
              <td>个人缴纳 元</td>
              <td>公司比例 %</td>
              <td>公司缴纳 元</td>
            </tr>
            <tr>
              <td>养老</td>
              <td>8%</td>
              <td id="yanglaoa"></td>
              <td>20%</td>
              <td id="yanglaob"></td>
            </tr>
            <tr>
              <td>医疗</td>
              <td>2%</td>
              <td id="yiliaoa"></td>
              <td>6%</td>
              <td id="yiliaob"></td>
            </tr>
            <tr>
              <td>失业</td>
              <td>0.5%</td>
              <td id="sya"></td>
              <td>1.5%</td>
              <td id="syb"></td>
            </tr>
            <tr>
              <td>工伤</td>
              <td>/</td>
              <td>/</td>
              <td>0.5%</td>
              <td id="gs"></td>
            </tr>
            <tr>
              <td>生育</td>
              <td>/</td>
              <td>/</td>
              <td>0.8%</td>
              <td id="sy"></td>
            </tr>
            <tr>
              <td>公积金</td>
              <td>12%</td>
              <td id="gjja"></td>
              <td>12%</td>
              <td id="gjjb"></td>
            </tr>
            <tr>
              <td>合计</td>
              <td>个人合计</td>
              <td id="alla"></td>
              <td>公司合计</td>
              <td id="allb"></td>
            </tr>
            <tr>
              <td>总额</td>
              <td colspan="4" id="all"></td>
            </tr>
          </table>
        </form>
      </div>
    </td>
  </tr>
</table>

<script src="../js/calc.js"></script>
</body>
</html>
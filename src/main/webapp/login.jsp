<%--
  Created by IntelliJ IDEA.
  User: HatsuneMona
  Date: 2020/4/3
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
<div>
    <form action="/LoginServlet" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td>
                    <label><input type="text" id="username" name="username"> </label>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <label><input type="password" id="password" name="password"> </label>
                </td>
            </tr>
            <tr>
                <td>
                    <label><input type="submit"></label>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

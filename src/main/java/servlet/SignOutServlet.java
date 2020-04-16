package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Hatsune Mona on 2020/4/16. 初音萌奈什喵的最可爱了喵！
 */
@WebServlet(name = "用户登出", value = "/SignOut")
public class SignOutServlet extends HttpServlet {
  
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
//    response.setContentType("text/html;charset=UTF-8");
//    PrintWriter out = response.getWriter();
//    String user = (String) request.getSession().getAttribute("loginUser");
//    if (user != null) {
//      request.setAttribute("loginUser", null);
//      out.print("登出成功！");
//    } else {
//      out.print("登出失败");
//    }
//    response.sendRedirect("/");
  }
  
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    if (request.getSession().getAttribute("loginUser") != null) {
      request.getSession().removeAttribute("loginUser");
      out.print("登出成功！");
    } else {
      out.print("登出失败");
    }
    response.sendRedirect("/");
  }
}

package servlet;

import DAO.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Users;

/**
 * Created by Hatsune Mona on 2020/4/8. 初音萌奈什喵的最可爱了喵！
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
  
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    response.setHeader("content-type", "text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    Users user = null;
    user = UserDao.UserLogin(username, password);
    PrintWriter out = response.getWriter();
    if (user != null) {
      out.print("登陆成功！欢迎用户：" + user.getUsername());
    } else {
      out.print("登陆失败");
    }
  }
  
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
  }
}

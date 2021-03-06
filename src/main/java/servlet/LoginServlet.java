package servlet;

import DAO.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsersEntity;

/**
 * Created by Hatsune Mona on 2020/4/3. 初音萌奈什喵的最可爱了喵！
 */
@WebServlet(name = "登录验证", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
  
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("logname");
    String password = request.getParameter("logpass");
    UsersEntity user = null;
    user = UserDao.UserLogin(username, password);
    PrintWriter out = response.getWriter();
    if (user != null) {
      out.print("登陆成功！欢迎用户：" + user.getUsername());
      request.getSession().setAttribute("loginUser", user.getUsername());
      response.sendRedirect("/");
    } else {
      out.print("登陆失败");
    }
  
    //将用户的名称保存到session属性中

//    //登录成功后，保存名称为JSESSIONID的id的cookie，值为session的id
//    Cookie loginCookie = new Cookie("sessionID", request.getSession().getId());
//    loginCookie.setMaxAge(60 * 100);
//    loginCookie.setPath("/");
//
//    response.addCookie(loginCookie);
  }
  
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
  }
}

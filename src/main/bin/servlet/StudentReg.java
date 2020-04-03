package servlet;

import DAO.UserDao;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import model.Users;

/**
 * Created by Hatsune Mona on 2020/4/2. 初音萌奈什喵的最可爱了喵！
 */
@WebServlet("/StudentReg")
public class StudentReg extends javax.servlet.http.HttpServlet {

  protected void doPost(javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException, IOException {

    Users user = new Users();
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    user.setUsername(request.getParameter("username"));
    user.setPhonenum(request.getParameter("phonenum"));
    user.setSex(request.getParameter("sex"));
    user.setRealname(request.getParameter("realname"));
    user.setUserpsw(request.getParameter("password2"));
    user.setSchoolname(request.getParameter("school"));
    user.setDept(request.getParameter("dept"));

    UserDao.insertUser(user);

  }

  protected void doGet(javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException, IOException {
  }
}

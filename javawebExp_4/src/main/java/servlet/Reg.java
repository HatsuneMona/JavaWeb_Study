package servlet;

import DAO.UserDAO;
import Model.UsersModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Reg", value = "/Reg")
public class Reg extends HttpServlet {
  
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
  
    UsersModel user = new UsersModel();
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
  
    user.setUserid(Integer.parseInt(request.getParameter("uid")));
    user.setUsername(request.getParameter("uname"));
    user.setUserpsw(request.getParameter("upw"));
    user.setUserrole(request.getParameter("urole"));
  
    UserDAO.UserInsert(user);
      response.sendRedirect("/index.jsp");
  }
  
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
  }
}

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

@WebServlet(name = "Update", value = "/Update")
public class Update extends HttpServlet {
  
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
    int uuid = Integer.parseInt(request.getParameter("uuid"));
    UsersModel user = UserDAO.getUser(uuid);
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    user.setUsername(request.getParameter("uuname"));
    user.setUserpsw(request.getParameter("uupw"));
    user.setUserrole(request.getParameter("uurole"));
    
    UserDAO.UserUpdate(uuid, user);
    response.sendRedirect("/index.jsp");
  }
  
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
  }
}

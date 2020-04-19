package servlet;

import DAO.DepartmentDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DepartmentsinfoEntity;

/**
 * Created by Hatsune Mona on 2020/4/11. 初音萌奈什喵的最可爱了喵！
 */
@WebServlet(name = "添加系部", value = "/DeptReg")
public class DeptReg extends HttpServlet {
  
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
  
    DepartmentsinfoEntity dept = new DepartmentsinfoEntity();
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    dept.setDepartmentNo(Integer.parseInt(request.getParameter("deptNo")));
    dept.setDepartmentName(request.getParameter("deptName"));
    dept.setDepartmentHead(Integer.parseInt(request.getParameter("deptHeader")));
    DepartmentDao.InsertDept(dept);
  }
  
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
  }
}

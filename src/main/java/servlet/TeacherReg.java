package servlet;

import DAO.TeacherDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TeachersinfoEntity;

/**
 * Created by Hatsune Mona on 2020/4/11. 初音萌奈什喵的最可爱了喵！
 */
@WebServlet(name = "教师注册",value = "/TeacherReg")
public class TeacherReg extends HttpServlet {
  
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
    TeachersinfoEntity teacher = new TeachersinfoEntity();
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    
    teacher.setTeacherNo(Integer.parseInt(request.getParameter("teacherNo")));
    teacher.setTeacherName(request.getParameter("teacherName"));
    teacher.setTeacherAge(Integer.parseInt(request.getParameter("teacherAge")));
    teacher.setTeacherSex(request.getParameter("sex"));
    teacher.setTeacherDepartment(Integer.parseInt(request.getParameter("teacherDept")));
  
    TeacherDao.InsertTeacher(teacher);
  }
  
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
  }
}

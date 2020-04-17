package servlet;

import DAO.TeacherDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TeachersinfoEntity;

/**
 * Created by Hatsune Mona on 2020/4/17. 初音萌奈什喵的最可爱了喵！
 */
@WebServlet(name = "教师信息修改", value = "/ModifyTeacherServlet")
public class ModifyTeacherServlet extends HttpServlet {
  
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
    TeachersinfoEntity teacher = new TeachersinfoEntity();
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    teacher.setTeacherNo(Integer.parseInt(request.getParameter("teacherNo")));
    teacher.setTeacherName(request.getParameter("teacherName"));
    teacher.setTeacherAge(Integer.parseInt(request.getParameter("teacherAge")));
    teacher.setTeacherSex(request.getParameter("sex"));
    teacher.setTeacherDepartment(Integer.parseInt(request.getParameter("teacherDept")));
    
    int delete = TeacherDao.DeleteTeacher(teacher.getTeacherNo());
    int insert = TeacherDao.InsertTeacher(teacher);
    if (delete == 1 && insert == 1) {
      out.println("<h3>修改成功！</h3>");
      try {
        TimeUnit.MILLISECONDS.sleep(1000);//毫秒
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      response.sendRedirect(
          "/ModifyPages/teacherModify.jsp?status=OK&choosetno=" + teacher.getTeacherNo());
    } else {
      System.out.println("删除状态：" + delete);
      System.out.println("写入状态" + insert);
      out.println("<h3>修改错误!</h3>");
      try {
        TimeUnit.MILLISECONDS.sleep(1000);//毫秒
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      response
          .sendRedirect(
              "/ModifyPages/teacherModify.jsp?status=Fail&choosetno=" + teacher.getTeacherNo());
    }
  }
  
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
  }
}

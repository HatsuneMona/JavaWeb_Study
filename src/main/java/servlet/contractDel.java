package servlet;

import DAO.ContractDao;
import DAO.TeacherDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Hatsune Mona on 2020/4/12. 初音萌奈什喵的最可爱了喵！
 */
@WebServlet(name = "删除合同", value = "/contractDel")
public class contractDel extends HttpServlet {
  
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String delete = request.getParameter("chooseid");
    if (ContractDao.DeleteContract(delete) == 1) {
      out.println("<h3>删除成功！</h3>");
      try {
        TimeUnit.MILLISECONDS.sleep(1000);//毫秒
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      response.sendRedirect("/QueryPages/contractQue.jsp?status=DeleteOK&tno=" + delete);
    } else {
      out.println("<h3>删除错误!</h3>");
      try {
        TimeUnit.MILLISECONDS.sleep(1000);//毫秒
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      response.sendRedirect("/QueryPages/contractQue.jsp?status=DeleteFail&tno=" + delete);
    }
    
  }
  
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
  }
}

package servlet;

import static javafx.scene.input.KeyCode.Z;

import DAO.ContractDao;
import DAO.TeacherDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContractEntity;
import model.TeachersinfoEntity;

/**
 * Created by Hatsune Mona on 2020/6/11. 初音萌奈什喵的最可爱了喵！
 */
@WebServlet(name = "添加合同", value = "/ContractReg")
public class contractReg extends HttpServlet {
  
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
  
    ContractEntity contract = new ContractEntity();
  
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

//    String dt = request.getParameter("getdate").replace('T', ' ');
//    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//    java.util.Date dftemp = null;
//    Timestamp ts=null;
//    try {
//      dftemp = df.parse(dt);
//      String time = df.format(dftemp);
//      ts = Timestamp.valueOf(time);
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
  
    contract.setContractid(request.getParameter("contractid"));
    contract.setContracttype(request.getParameter("contracttype"));
    //这个request.getParameter("getdate")传进来的是【2020-06-11T20:06】
    contract.setGatdate(Timestamp.valueOf(LocalDateTime.now()));
    contract.setLawer(request.getParameter("lawer"));
    contract.setOperator(request.getParameter("operator"));
    contract.setRemark(request.getParameter("remark"));
  
    int insert = ContractDao.InsertContract(contract);
    if (insert == 1) {
      response.sendRedirect("/RegPages/contractReg.jsp?status=OK&tno=" + contract.getContractid());
    } else {
      response.sendRedirect("/RegPages/contractReg.jsp?status=Fail");
    }
  }
  
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
  }
}

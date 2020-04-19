package DAO;/**
 * Created by Hatsune Mona on 2020/4/10. 初音萌奈什喵的最可爱了喵！
 */

import DBUtil.SQLConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DepartmentsinfoEntity;

/**
 * @program: JavaWeb
 * @description: 对courseinfo数据库的操作
 * @author: Created by Hatsune Mona. 初音萌奈什喵的最可爱了喵！
 * @create: 2020-04-10 21:12
 **/
public class DepartmentDao extends DAO {
  
  static public int InsertDept(DepartmentsinfoEntity deptInfo) {
    
    String insertSQL = "INSERT INTO departmentsinfo VALUES(?,?,?)";
    int flag = 0;
    connection = SQLConnect.getConnection();
    try {
      pstmt = connection.prepareStatement(insertSQL);
      pstmt.setInt(1, deptInfo.getDepartmentNo());
      pstmt.setString(2, deptInfo.getDepartmentName());
      pstmt.setInt(3, deptInfo.getDepartmentHead());
      flag = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      CloseConnection();
    }
    return flag;
  }
  
  static public ArrayList<DepartmentsinfoEntity> SearchDept(Integer deptNo) {
    ArrayList<DepartmentsinfoEntity> deptlist = new ArrayList<>();
    String selectSQL;
    connection = SQLConnect.getConnection();
    try {
      if (deptNo == null) {
        selectSQL = "SELECT * FROM departmentsinfo";
        pstmt = connection.prepareStatement(selectSQL);
      } else {
        selectSQL = "SELECT * FROM departmentsinfo WHERE departmentNo = ?";
        pstmt = connection.prepareStatement(selectSQL);
        pstmt.setInt(1, deptNo);
      }
      ResultSet resultSet = pstmt.executeQuery();
      while (resultSet.next()) {
        DepartmentsinfoEntity deptTemp = new DepartmentsinfoEntity();
        deptTemp.setDepartmentNo(resultSet.getInt(1));
        deptTemp.setDepartmentName(resultSet.getString(2));
        deptTemp.setDepartmentHead(resultSet.getInt(3));
        deptlist.add(deptTemp);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      CloseConnection();
    }
    return deptlist;
  }
  
  static public int DeleteDept(int deptNo) {
    connection = SQLConnect.getConnection();
    int flag = 0;
    String deleteSQL = "DELETE FROM departmentsinfo WHERE departmentNo = ?";
    try {
      pstmt = connection.prepareStatement(deleteSQL);
      pstmt.setInt(1, deptNo);
      flag = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      CloseConnection();
    }
    return flag;
  }
}

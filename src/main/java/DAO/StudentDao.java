package DAO;/**
 * Created by Hatsune Mona on 2020/4/10. 初音萌奈什喵的最可爱了喵！
 */

import DBUtil.SQLConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.CourseinfoEntity;
import model.StudentsinfoEntity;

/**
 * @program: JavaWeb
 * @description: 对courseinfo数据库的操作
 * @author: Created by Hatsune Mona. 初音萌奈什喵的最可爱了喵！
 * @create: 2020-04-10 21:12
 **/
public class StudentDao {
  
  static private Connection connection = SQLConnect.getConnection();//打开数据库连接
  static private PreparedStatement pstmt = null;
  
  static public void CloseConnection(){
    if (pstmt != null) {
      try {
        pstmt.close();
        pstmt = null;
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (connection!= null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  
  static public int InsertCourse(StudentsinfoEntity studentInfo) {
    connection = SQLConnect.getConnection();//打开数据库连接
    String insertSQL = "INSERT INTO studentsinfo VALUES(?,?,?,?,?)";
    int flag = 0;
    try {
      pstmt = connection.prepareStatement(insertSQL);
      pstmt.setInt(1, studentInfo.getStudentNo());
      pstmt.setString(2, studentInfo.getStudentName());
      pstmt.setInt(3, studentInfo.getStudentAge());
      pstmt.setString(4, studentInfo.getStudentSex());
      pstmt.setInt(5, studentInfo.getStudentDepartment());
      flag = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      CloseConnection();
    }
    return flag;
  }
}

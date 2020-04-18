package DAO;/**
 * Created by Hatsune Mona on 2020/4/10. 初音萌奈什喵的最可爱了喵！
 */

import DBUtil.SQLConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TeachersinfoEntity;

/**
 * @program: JavaWeb
 * @description: 对courseinfo数据库的操作
 * @author: Created by Hatsune Mona. 初音萌奈什喵的最可爱了喵！
 * @create: 2020-04-10 21:12
 **/
public class TeacherDao extends DAO {

//  static private Connection connection;//打开数据库连接
//  static private PreparedStatement pstmt = null;
//
//  static private void CloseConnection() {
//    if (pstmt != null) {
//      try {
//        pstmt.close();
//        pstmt = null;
//      } catch (SQLException e) {
//        e.printStackTrace();
//      }
//    }
//    if (connection != null) {
//      try {
//        connection.close();
//      } catch (SQLException e) {
//        e.printStackTrace();
//      }
//    }
//  }
  
  static public int InsertTeacher(TeachersinfoEntity teacherInfo) {
    connection = SQLConnect.getConnection();
    String insertSQL = "INSERT INTO teachersinfo VALUES(?,?,?,?,?)";
    int flag = 0;
    try {
      pstmt = connection.prepareStatement(insertSQL);
      pstmt.setInt(1, teacherInfo.getTeacherNo());
      pstmt.setString(2, teacherInfo.getTeacherName());
      pstmt.setInt(3, teacherInfo.getTeacherAge());
      pstmt.setString(4, teacherInfo.getTeacherSex());
      pstmt.setInt(5, teacherInfo.getTeacherDepartment());
      flag = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      CloseConnection();
    }
    return flag;
  }
  
  static public int DeleteTeacher(int teacherNo) {
    connection = SQLConnect.getConnection();
    int flag = 0;
    String deleteSQL = "DELETE FROM teachersinfo WHERE TeacherNo = ?";
    try {
      pstmt = connection.prepareStatement(deleteSQL);
      pstmt.setInt(1, teacherNo);
      flag = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      CloseConnection();
    }
    return flag;
  }
  
  static public ArrayList<TeachersinfoEntity> SearchTeacher(Integer no) {
    ArrayList<TeachersinfoEntity> teacherList = new ArrayList<TeachersinfoEntity>();
    connection = SQLConnect.getConnection();
    String searchSQL;
    try {
      if (no == null) {
        searchSQL = "SELECT * FROM teachersinfo";
        pstmt = connection.prepareStatement(searchSQL);
      } else {
        searchSQL = "SELECT * FROM teachersinfo WHERE teacherNo = ?";
        pstmt = connection.prepareStatement(searchSQL);
        pstmt.setInt(1, no);
      }
      ResultSet resultSet = pstmt.executeQuery();
      while (resultSet.next()) {
        TeachersinfoEntity teacherTemp = new TeachersinfoEntity();
        teacherTemp.setTeacherNo(resultSet.getInt(1));
        teacherTemp.setTeacherName(resultSet.getString(2));
        teacherTemp.setTeacherAge(resultSet.getInt(3));
        teacherTemp.setTeacherSex(resultSet.getString(4));
        teacherTemp.setTeacherDepartment(resultSet.getInt(5));
        teacherList.add(teacherTemp);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      CloseConnection();
    }
    return teacherList;
  }
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Users;
import DBUtil.*;
import module.MD5;

/**
 * Created by Hatsune Mona on 2020/3/27. 初音萌奈什喵的最可爱了喵！
 */
public class UserDao {

  public static int insertUser(Users user) {
    Connection connection = SQLConnect.getConnection();//打开数据库连接
    PreparedStatement pstmt = null;
    int flag = 0;
    String insertUserSQL = "INSERT INTO Users VALUES(?,?,?,?,?,?,?)";
    try {
      pstmt = connection.prepareStatement(insertUserSQL);
      pstmt.setString(1, user.getUsername());
      pstmt.setLong(2, Long.parseLong(user.getPhonenum()));
      pstmt.setString(3, user.getSex());
      pstmt.setString(4, user.getRealname());
      pstmt.setString(5, user.getUserpsw());
      pstmt.setString(6, user.getSchoolname());
      pstmt.setString(7, user.getDept());
      flag = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return flag;
  }

  public static Users UserLogin(String username, String password) {
    Users user = new Users();
    PreparedStatement pstmt = null;
    int flag = 0;
    String searchUserSQL = "SELECT * FROM Users WHERE username=? AND password=?";
    try {
      pstmt.setString(1, username);
      pstmt.setString(2, MD5.GetMD5(password));
      flag = pstmt.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      if (flag == 1) {
        System.out.println("登陆成功");
      } else {

      }
    }

    return user;
  }
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UsersEntity;
import DBUtil.*;
import module.MD5;

/**
 * Created by Hatsune Mona on 2020/3/27. 初音萌奈什喵的最可爱了喵！
 */
public class UserDao {

  public static int insertUser(UsersEntity user) {
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

  public static UsersEntity UserLogin(String username, String password) {
    Connection connection = SQLConnect.getConnection();//打开数据库连接
    UsersEntity user = new UsersEntity();
    PreparedStatement pstmt = null;
    //int flag = 0;
    ResultSet resault = null;
    String searchUserSQL = "SELECT * FROM users WHERE username= ? AND password= ? ";
    try {
      pstmt = connection.prepareStatement(searchUserSQL);
      pstmt.setString(1, username);
      pstmt.setString(2, MD5.GetMD5(password));
      resault = pstmt.executeQuery();
      if (resault != null) {
        System.out.println(username + "Login Success！");
        while (resault.next()) {
          user.setUsername(resault.getString("username"));
          user.setRealname(resault.getString("realname"));
          user.setSex(resault.getString("sex"));
          user.setDept(resault.getString("password"));
          user.setSchoolname(resault.getString("school"));
          user.setPhonenum(resault.getString("phonenum"));
        }
      } else {
        System.out.println(username + "Login Fail！");
        user = null;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
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
    return user;
  }
}

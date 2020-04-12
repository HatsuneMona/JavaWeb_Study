package DAO;/**
 * Created by Hatsune Mona on 2020/4/12. 初音萌奈什喵的最可爱了喵！
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program: JavaWeb
 * @description:
 * @author: Created by Hatsune Mona. 初音萌奈什喵的最可爱了喵！
 * @create: 2020-04-12 13:53
 **/
public class DAO {
  
  static protected Connection connection;//打开数据库连接
  static protected PreparedStatement pstmt = null;
  
  static protected void CloseConnection() {
    if (pstmt != null) {
      try {
        pstmt.close();
        pstmt = null;
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
}

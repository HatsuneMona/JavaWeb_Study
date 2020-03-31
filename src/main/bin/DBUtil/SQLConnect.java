package DBUtil;

import java.sql.*;

/**
 * Created by Hatsune Mona on 2020/3/27. 初音萌奈什喵的最可爱了喵！
 */
public class SQLConnect {

  /**
   * 获取（打开）数据库连接
   *
   * @return 数据库连接对象
   */
  public static Connection getConnection() {
    //数据库连接
    Connection connection = null;

    try {
      //1. 注册数据库驱动；参数是MySQL驱动，从MySQL官网下载
      // 大小写严格区分
      Class.forName("com.mysql.cj.jdbc.Driver");
      //2. 获取连接（打开数据库连接）
      //url:连接字符串,每种数据库不相同    root数据库用户名   root数据库密码
      String url = "jdbc:mysql://123.56.220.189:3306/JavaWeb?UseUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
      connection = DriverManager.getConnection(url, "JavaWeb", "JavaWebPw");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  /**
   * 关闭数据库连接
   *
   * @param connection 要被关闭的连接对象
   */
  public static void closeConnection(Connection connection) {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}

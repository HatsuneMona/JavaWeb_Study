package DAO;

import DBUtil.SQLConnect;
import com.oracle.jrockit.jfr.ContentType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ContractEntity;
import model.ContractEntity;


public class ContractDao extends DAO {
  
  //父类DAO，由于数据库的连接与关闭是所有DAO共用的。
  //但是由于换数据库了，所以……还是需要重新写一遍。不过CloseConnection()还是共用的。
  public static Connection getConnection() {
    //数据库连接
    Connection connection = null;
    
    try {
      //数据库引擎（驱动）
      Class.forName("com.mysql.jdbc.Driver");
      //获取连接（打开数据库连接）
      //url:连接字符串
      String url = "jdbc:mysql://123.56.220.189:3306/Exp?UseUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
      connection = DriverManager.getConnection(url, "JavaWeb", "JavaWebPw");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }
  
  //添加合同领取信息
  //参数：ContractEntity contractInfo
  //返回：数据库中受影响的行数
  static public int InsertContract(ContractEntity contractInfo) {
    connection = getConnection();                        //打开数据库连接
    String insertSQL = "INSERT INTO contract VALUES(?,?,?,?,?,?)";  //定义SQL语句模板
    int flag = 0;                                                   //记录受影响的行数。
    try {
      pstmt = connection.prepareStatement(insertSQL);               //指定模板
      pstmt.setString(1, contractInfo.getContractid()); //修改模板
      pstmt.setString(2, contractInfo.getContracttype());
      pstmt.setTimestamp(3, contractInfo.getGatdate());
      pstmt.setString(4, contractInfo.getLawer());
      pstmt.setString(5, contractInfo.getOperator());
      pstmt.setString(6, contractInfo.getRemark());
      flag = pstmt.executeUpdate();                                 //更新数据库
    } catch (SQLException e) {                                      //若出现问题，则捕获问题
      e.printStackTrace();
    } finally {                                                     //无论是否出现问题，都要关闭数据库连接
      CloseConnection();
    }
    return flag;
  }
  
  //删除合同领取信息
  //参数：String contractId 要被删除的id
  //返回：数据库中受影响的行数
  static public int DeleteContract(String contractId) {
    connection = getConnection();
    int flag = 0;
    String deleteSQL = "DELETE FROM contract WHERE contractid = ?";
    try {
      pstmt = connection.prepareStatement(deleteSQL);
      pstmt.setString(1, contractId);
      flag = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      CloseConnection();
    }
    return flag;
  }
  
  //查询合同领取信息
  //参数：String id  要查询合同信息的ID，若为null，则全查
  //返回：ArrayList<ContractEntity>  查询到的内容集合
  static public ArrayList<ContractEntity> SearchContract(String id) {
    ArrayList<ContractEntity> contractList = new ArrayList<>();
    connection = getConnection();
    String searchSQL;
    try {
      if (id == null) {                                               //如果传入参数的id为null，则全查
        searchSQL = "SELECT * FROM contract";
        pstmt = connection.prepareStatement(searchSQL);
      } else {                                                       //如果传入参数的id为具体的值，则创建模板并查询
        searchSQL = "SELECT * FROM contract WHERE contractid = ?";
        pstmt = connection.prepareStatement(searchSQL);
        pstmt.setString(1, id);
      }
      ResultSet resultSet = pstmt.executeQuery();
      while (resultSet.next()) {                                      //这个循环一直会循环到最后一条信息
        ContractEntity contractTemp = new ContractEntity();
        contractTemp.setContractid(resultSet.getString(1));
        contractTemp.setContracttype(resultSet.getString(2));
        contractTemp.setGatdate(resultSet.getTimestamp(3));
        contractTemp.setLawer(resultSet.getString(4));
        contractTemp.setOperator(resultSet.getString(5));
        contractTemp.setRemark(resultSet.getString(6));
        contractList.add(contractTemp);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      CloseConnection();
    }
    return contractList;
  }
}

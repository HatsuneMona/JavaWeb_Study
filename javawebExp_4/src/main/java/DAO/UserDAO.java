package DAO;

import Model.UsersModel;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDAO {
  
  static public List<UsersModel> getAllUsers() throws IOException {
    /**
     *  1、获得 SqlSessionFactory
     *  2、获得 SqlSession
     *  3、调用在 mapper 文件中配置的 SQL 语句
     */
    String resource = null;           //定位核心配置文件
    InputStream inputStream = null;
    SqlSession sqlSession = null;
    resource = "sqlMapConfig.xml";
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
        .build(inputStream);        // 创建 SqlSessionFactory
    sqlSession = sqlSessionFactory.openSession();            // 获取到 SqlSession
    
    // 调用 mapper 中的方法：命名空间 + id
    List<UsersModel> UsersModelList = sqlSession.selectList("top.mona.Exp/SQLMapper.findAllUsers");
    return UsersModelList;
  }
  
  static public void UserUpdate(int userid, UsersModel user) {
    String resource = null;           //定位核心配置文件
    InputStream inputStream = null;
    SqlSession sqlSession = null;
    resource = "sqlMapConfig.xml";
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
        .build(inputStream);        // 创建 SqlSessionFactory
    sqlSession = sqlSessionFactory.openSession();            // 获取到 SqlSession
    
    UsersModel u = sqlSession.selectOne("top.mona.Exp/SQLMapper.get", userid);
    
    sqlSession.update("top.mona.Exp/SQLMapper.update", u);
    sqlSession.commit();            //默认是不自动提交，必须手工提交
  }
  
  static public UsersModel getUser(int userid) throws IOException {
    String resource = null;           //定位核心配置文件
    InputStream inputStream = null;
    SqlSession sqlSession = null;
    resource = "sqlMapConfig.xml";
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
        .build(inputStream);        // 创建 SqlSessionFactory
    sqlSession = sqlSessionFactory.openSession();            // 获取到 SqlSession
    // 调用 mapper 中的方法：命名空间 + id
    return sqlSession.selectOne("top.mona.Exp/SQLMapper.get", userid);
  }
  
  static public void UserInsert(UsersModel user) {
    String resource = "sqlMapConfig.xml";           //定位核心配置文件
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
        .build(inputStream);        // 创建 SqlSessionFactory
    
    SqlSession sqlSession = sqlSessionFactory.openSession();            //获取到 SqlSession
    
    sqlSession.insert("top.mona.Exp/SQLMapper.insert", user);
    sqlSession.commit();            //默认是不自动提交，必须手工提交
  }
  
  static public void testDeleteById(int userid) {
    String resource = "sqlMapConfig.xml";           //定位核心配置文件
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
        .build(inputStream);        // 创建 SqlSessionFactory
    
    SqlSession sqlSession = sqlSessionFactory.openSession();            // 获取到 SqlSession
    
    sqlSession.delete("top.mona.Exp/SQLMapper.deleteById", userid);
    sqlSession.commit();            //默认是不自动提交，必须手工提交
  }
}

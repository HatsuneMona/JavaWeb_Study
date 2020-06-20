package testModel;

import Model.UsersModel;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class UsersModelTest {
  
  @Test
  public void testUser() throws IOException {
    /**
     *  1、获得 SqlSessionFactory
     *  2、获得 SqlSession
     *  3、调用在 mapper 文件中配置的 SQL 语句
     */
    String resource = "sqlMapConfig.xml";           // 定位核心配置文件
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
        .build(inputStream);    // 创建 SqlSessionFactory
    
    SqlSession sqlSession = sqlSessionFactory.openSession();    // 获取到 SqlSession
    
    // 调用 mapper 中的方法：命名空间 + id
    List<UsersModel> UsersModelList = sqlSession.selectList("top.mona.Exp/SQLMapper.findAllUsers");
    
    for (UsersModel u : UsersModelList) {
      System.out.println(u);
    }
  }
  
  @Test
  public void testInsert() {
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
    
    UsersModel u = new UsersModel();
    u.setUserid(23333);
    u.setUsername("咕噜灵波");
    u.setUserpsw("PW");
    u.setUserrole("test");
    
    sqlSession.insert("top.mona.Exp/SQLMapper.insert", u);
    sqlSession.commit();            //默认是不自动提交，必须手工提交
  }
  
  @Test
  public void testUpdate() {
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
    
    UsersModel u = sqlSession.selectOne("top.mona.Exp/SQLMapper.get", 23332);   // 获得 id=2 的记录
    u.setUsername("姓名已修改");
    u.setUserrole("喵");
    
    // sqlSession.insert("yeepay.payplus.mapper.UsersModel.update", p);
    sqlSession.update("top.mona.Exp/SQLMapper.update", u);
    sqlSession.commit();            //默认是不自动提交，必须手工提交
  }
  
  @Test
  public void testDeleteById() {
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
    
    sqlSession.delete("top.mona.Exp/SQLMapper.deleteById", 23333);
    sqlSession.commit();            //默认是不自动提交，必须手工提交
  }
}

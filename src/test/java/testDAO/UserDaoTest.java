package testDAO;

import DAO.UserDao;
import java.util.Random;
import model.UsersEntity;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * UserDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>3 30, 2020</pre>
 */
public class UserDaoTest {
  
  UsersEntity testuser;
  
  //length用户要求产生字符串的长度
  private String getRandomString(int length) {
    String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random = new Random();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < length; i++) {
      int number = random.nextInt(62);
      sb.append(str.charAt(number));
    }
    return sb.toString();
  }
  
  @Before
  public void before() throws Exception {
    testuser = new UsersEntity(getRandomString(5), "随机用户", "male",
        "12345678", "喵喵工业学院", "12345678901",
        "12345678901");
  }
  
  @After
  public void after() throws Exception {
  }
  
  /**
   * Method: insertUser(UsersEntity user)
   */
  @Test
  public void testInsertUser() throws Exception {
//TODO: Test goes here...
    UserDao.insertUser(testuser);
  }
  
  /**
   * Method: UserLogin(String username, String password)
   */
  @Test
  public void testUserLogin() throws Exception {
//TODO: Test goes here...
    UserDao.UserLogin("testuser", "12345678");//正确的
    UserDao.UserLogin("testuser", "000");//错误的
  }
  
  
} 

package testDAO;

import DAO.UserDao;
import model.Users;
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

  Users testuser;

  @Before
  public void before() throws Exception {
    testuser = new Users("testuser", "喵喵", "male",
        "12345678", "喵喵工业学院", "12345678901",
        "12345678901");
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: insertUser(Users user)
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

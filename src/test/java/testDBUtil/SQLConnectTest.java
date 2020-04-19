package testDBUtil;

import DBUtil.SQLConnect;
import java.sql.Connection;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * SQLConnect Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>3�� 30, 2020</pre>
 */
public class SQLConnectTest {
  
  Connection testConnection;
  
  @Before
  public void before() throws Exception {
  }
  
  @After
  public void after() throws Exception {
  }
  
  /**
   * Method: getConnection()
   */
  @Test
  public void testGetConnection() throws Exception {
//TODO: Test goes here...
    testConnection = SQLConnect.getConnection();
    System.out.println();
  }
  
  /**
   * Method: closeConnection(Connection connection)
   */
  @Test
  public void testCloseConnection() throws Exception {
//TODO: Test goes here...
    SQLConnect.closeConnection(testConnection);
  }
  
  
}

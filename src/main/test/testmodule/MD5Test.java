package testmodule;

import module.MD5;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * MD5 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>4ÔÂ 3, 2020</pre>
 */
public class MD5Test {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: GetMD5(String string)
   */
  @Test
  public void testGetMD5() throws Exception {
//TODO: Test goes here...
    System.out.println(MD5.GetMD5("testMD5"));
    System.out.println(MD5.GetMD5("testMD5"));
    System.out.println(MD5.GetMD5("12345678"));
  }


  /**
   * Method: byte2Hex(byte[] bys)
   */
  @Test
  public void testByte2Hex() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = MD5.getClass().getMethod("byte2Hex", byte[].class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
  }

} 

package testDAO;

import DAO.DepartmentDao;
import model.DepartmentsinfoEntity;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * DepartmentDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>4月 18, 2020</pre>
 */
public class DepartmentDaoTest {
  
  DepartmentsinfoEntity deptinfo = new DepartmentsinfoEntity();
  
  
  @Before
  public void before() throws Exception {
    deptinfo.setDepartmentNo(95);
    deptinfo.setDepartmentName("DAO测试系");
    deptinfo.setDepartmentHead(9500001);
  }
  
  @After
  public void after() throws Exception {
    try {
      if (DepartmentDao.SearchDept(95).size() == 1) {
        DepartmentDao.DeleteDept(95);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Method: InsertDept(DepartmentsinfoEntity deptInfo)
   */
  @Test
  public void testInsertDept() throws Exception {
    DepartmentDao.InsertDept(deptinfo);
    System.out.println(DepartmentDao.SearchDept(95).get(0).getDepartmentName());
  }
  
  /**
   * Method: SearchDept(Integer deptNo)
   */
  @Test
  public void testSearchDept() throws Exception {
    System.out.println("数据库现有系部数量：");
    System.out.println(DepartmentDao.SearchDept(null).size());
  }
  
  /**
   * Method: DeleteDept(int deptNo)
   */
  @Test
  public void testDeleteDept() throws Exception {
    DepartmentDao.DeleteDept(95);
  }
  
  
} 

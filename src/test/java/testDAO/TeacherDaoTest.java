package testDAO;

import DAO.TeacherDao;
import java.util.ArrayList;
import model.TeachersinfoEntity;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TeacherDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>4�� 11, 2020</pre>
 */
public class TeacherDaoTest {
  
  TeachersinfoEntity teacher = new TeachersinfoEntity();
  int random;
  
  @Before
  public void before() throws Exception {
    random = (int) (Math.random() * 900 + 100);
    teacher.setTeacherNo(9999000 + random);
    teacher.setTeacherDepartment(99);
    teacher.setTeacherName("测试的老师");
    teacher.setTeacherAge(1);
    teacher.setTeacherSex("other");
  }
  
  @After
  public void after() throws Exception {
  }
  
  
  /**
   * Method: InsertTeacher(TeachersinfoEntity teacherInfo)
   */
  @Test
  public void testInsertTeacher() throws Exception {
    random = (int) (Math.random() * 900 + 100);
    if (TeacherDao.InsertTeacher(teacher) == 1) {
      System.out.println("TeacherDAO Insert Test OK!");
    } else {
      System.out.println("TeacherDAO Insert BAD");
    }
    TeacherDao.DeleteTeacher(teacher.getTeacherNo());
  }
  
  /**
   * Method: CloseConnection()
   */
  @Test
  public void testCloseConnection() throws Exception {
    random = (int) (Math.random() * 900 + 100);
    TeacherDao.InsertTeacher(teacher);
    if (TeacherDao.DeleteTeacher(teacher.getTeacherNo()) == 1) {
      System.out.println("TeacherDAO Delete Test OK!");
    } else {
      System.out.println("TeacherDAO Delete BAD");
    }
  }
  
  /**
   *
   * Method: SearchTeacher()
   *
   */
  @Test
  public void testSearchTeacher() throws Exception {
    ArrayList<TeachersinfoEntity> tlist = new ArrayList<>();
    tlist = TeacherDao.SearchTeacher(null);
    System.out.print(tlist.size());
    tlist = TeacherDao.SearchTeacher(10086);
    System.out.print(tlist.size());
  }
  
} 

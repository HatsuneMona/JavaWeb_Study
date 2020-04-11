package testDAO; 

import model.TeachersinfoEntity;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* TeacherDao Tester. 
* 
* @author <Authors name> 
* @since <pre>4�� 11, 2020</pre> 
* @version 1.0 
*/ 
public class TeacherDaoTest { 

  TeachersinfoEntity teacher = new TeachersinfoEntity();
  int random;
@Before
public void before() throws Exception {
  random = (int)(Math.random()*900+100);
  teacher.setTeacherNo(9999000+random);
  teacher.setTeacherDepartment(99);
  teacher.setTeacherName("测试的老师");
  teacher.setTeacherAge(1);
  teacher.setTeacherSex("other");
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: InsertTeacher(TeachersinfoEntity teacherInfo)
* 
*/ 
@Test
public void testInsertTeacher() throws Exception {
//TODO: Test goes here...

} 


} 

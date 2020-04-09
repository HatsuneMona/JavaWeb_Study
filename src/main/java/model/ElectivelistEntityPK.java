package model;/**
 * Created by Hatsune Mona on 2020/4/9. 初音萌奈什喵的最可爱了喵！
 */

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @program: JavaWeb
 * @description:
 * @author: Created by Hatsune Mona. 初音萌奈什喵的最可爱了喵！
 * @create: 2020-04-09 16:30
 **/
public class ElectivelistEntityPK implements Serializable {
  
  private int studentNo;
  private int courseNo;
  
  @Column(name = "studentNo")
  @Id
  public int getStudentNo() {
    return studentNo;
  }
  
  public void setStudentNo(int studentNo) {
    this.studentNo = studentNo;
  }
  
  @Column(name = "courseNo")
  @Id
  public int getCourseNo() {
    return courseNo;
  }
  
  public void setCourseNo(int courseNo) {
    this.courseNo = courseNo;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElectivelistEntityPK that = (ElectivelistEntityPK) o;
    return studentNo == that.studentNo &&
        courseNo == that.courseNo;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(studentNo, courseNo);
  }
}

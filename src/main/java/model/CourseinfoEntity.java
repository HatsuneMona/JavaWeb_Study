package model;/**
 * Created by Hatsune Mona on 2020/4/9. 初音萌奈什喵的最可爱了喵！
 */

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: JavaWeb
 * @description:
 * @author: Created by Hatsune Mona. 初音萌奈什喵的最可爱了喵！
 * @create: 2020-04-09 16:30
 **/
@Entity
@Table(name = "courseinfo", schema = "javaweb")
public class CourseinfoEntity {
  
  private int courseNo;
  private String courseName;
  private int courseCredit;
  
  @Id
  @Column(name = "courseNo")
  public int getCourseNo() {
    return courseNo;
  }
  
  public void setCourseNo(int courseNo) {
    this.courseNo = courseNo;
  }
  
  @Basic
  @Column(name = "courseName")
  public String getCourseName() {
    return courseName;
  }
  
  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
  
  @Basic
  @Column(name = "courseCredit")
  public int getCourseCredit() {
    return courseCredit;
  }
  
  public void setCourseCredit(int courseCredit) {
    this.courseCredit = courseCredit;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CourseinfoEntity that = (CourseinfoEntity) o;
    return courseNo == that.courseNo &&
        courseCredit == that.courseCredit &&
        Objects.equals(courseName, that.courseName);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(courseNo, courseName, courseCredit);
  }
}

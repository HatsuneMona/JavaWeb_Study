package model;/**
 * Created by Hatsune Mona on 2020/4/10. 初音萌奈什喵的最可爱了喵！
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
 * @create: 2020-04-10 21:53
 **/
@Entity
@Table(name = "courseinfo", schema = "javaweb")
public class CourseinfoEntity {
  
  private int courseNo;
  private String courseName;
  private Integer firstClass;
  private int courseCredit;
  private Integer teacher;
  
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
  @Column(name = "firstClass")
  public Integer getFirstClass() {
    return firstClass;
  }
  
  public void setFirstClass(Integer firstClass) {
    this.firstClass = firstClass;
  }
  
  @Basic
  @Column(name = "courseCredit")
  public int getCourseCredit() {
    return courseCredit;
  }
  
  public void setCourseCredit(int courseCredit) {
    this.courseCredit = courseCredit;
  }
  
  @Basic
  @Column(name = "teacher")
  public Integer getTeacher() {
    return teacher;
  }
  
  public void setTeacher(Integer teacher) {
    this.teacher = teacher;
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
        Objects.equals(courseName, that.courseName) &&
        Objects.equals(firstClass, that.firstClass) &&
        Objects.equals(teacher, that.teacher);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(courseNo, courseName, firstClass, courseCredit, teacher);
  }
}

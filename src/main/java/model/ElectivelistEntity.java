package model;/**
 * Created by Hatsune Mona on 2020/4/10. 初音萌奈什喵的最可爱了喵！
 */

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @program: JavaWeb
 * @description:
 * @author: Created by Hatsune Mona. 初音萌奈什喵的最可爱了喵！
 * @create: 2020-04-10 21:57
 **/
@Entity
@Table(name = "electivelist", schema = "javaweb")
@IdClass(ElectivelistEntityPK.class)
public class ElectivelistEntity {
  
  private int studentNo;
  private int courseNo;
  private int grade;
  
  @Id
  @Column(name = "studentNo")
  public int getStudentNo() {
    return studentNo;
  }
  
  public void setStudentNo(int studentNo) {
    this.studentNo = studentNo;
  }
  
  @Id
  @Column(name = "courseNo")
  public int getCourseNo() {
    return courseNo;
  }
  
  public void setCourseNo(int courseNo) {
    this.courseNo = courseNo;
  }
  
  @Basic
  @Column(name = "grade")
  public int getGrade() {
    return grade;
  }
  
  public void setGrade(int grade) {
    this.grade = grade;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElectivelistEntity that = (ElectivelistEntity) o;
    return studentNo == that.studentNo &&
        courseNo == that.courseNo &&
        grade == that.grade;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(studentNo, courseNo, grade);
  }
}

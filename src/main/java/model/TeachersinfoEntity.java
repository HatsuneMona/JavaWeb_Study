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
 * @create: 2020-04-10 21:57
 **/
@Entity
@Table(name = "teachersinfo", schema = "javaweb")
public class TeachersinfoEntity {
  
  private int teacherNo;
  private String teacherName;
  private int teacherAge;
  private String teacherSex;
  private int teacherDepartment;
  
  @Id
  @Column(name = "teacherNo")
  public int getTeacherNo() {
    return teacherNo;
  }
  
  public void setTeacherNo(int teacherNo) {
    this.teacherNo = teacherNo;
  }
  
  @Basic
  @Column(name = "teacherName")
  public String getTeacherName() {
    return teacherName;
  }
  
  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }
  
  @Basic
  @Column(name = "teacherAge")
  public int getTeacherAge() {
    return teacherAge;
  }
  
  public void setTeacherAge(int teacherAge) {
    this.teacherAge = teacherAge;
  }
  
  @Basic
  @Column(name = "teacherSex")
  public String getTeacherSex() {
    return teacherSex;
  }
  
  public void setTeacherSex(String teacherSex) {
    this.teacherSex = teacherSex;
  }
  
  @Basic
  @Column(name = "teacherDepartment")
  public int getTeacherDepartment() {
    return teacherDepartment;
  }
  
  public void setTeacherDepartment(int teacherDepartment) {
    this.teacherDepartment = teacherDepartment;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TeachersinfoEntity that = (TeachersinfoEntity) o;
    return teacherNo == that.teacherNo &&
        teacherAge == that.teacherAge &&
        teacherSex == that.teacherSex &&
        teacherDepartment == that.teacherDepartment &&
        Objects.equals(teacherName, that.teacherName);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(teacherNo, teacherName, teacherAge, teacherSex, teacherDepartment);
  }
}

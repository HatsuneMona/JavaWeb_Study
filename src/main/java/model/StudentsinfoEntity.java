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
@Table(name = "studentsinfo", schema = "javaweb")
public class StudentsinfoEntity {
  
  private int studentNo;
  private String studentName;
  private int studentAge;
  private String studentSex;
  private int studentDepartment;
  
  @Id
  @Column(name = "studentNo")
  public int getStudentNo() {
    return studentNo;
  }
  
  public void setStudentNo(int studentNo) {
    this.studentNo = studentNo;
  }
  
  @Basic
  @Column(name = "studentName")
  public String getStudentName() {
    return studentName;
  }
  
  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }
  
  @Basic
  @Column(name = "studentAge")
  public int getStudentAge() {
    return studentAge;
  }
  
  public void setStudentAge(int studentAge) {
    this.studentAge = studentAge;
  }
  
  @Basic
  @Column(name = "studentSex")
  public String getStudentSex() {
    return studentSex;
  }
  
  public void setStudentSex(String studentSex) {
    this.studentSex = studentSex;
  }
  
  @Basic
  @Column(name = "studentDepartment")
  public int getStudentDepartment() {
    return studentDepartment;
  }
  
  public void setStudentDepartment(int studentDepartment) {
    this.studentDepartment = studentDepartment;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudentsinfoEntity that = (StudentsinfoEntity) o;
    return studentNo == that.studentNo &&
        studentAge == that.studentAge &&
        studentSex == that.studentSex &&
        studentDepartment == that.studentDepartment &&
        Objects.equals(studentName, that.studentName);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(studentNo, studentName, studentAge, studentSex, studentDepartment);
  }
}

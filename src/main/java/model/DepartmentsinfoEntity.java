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
@Table(name = "departmentsinfo", schema = "javaweb")
public class DepartmentsinfoEntity {
  
  private int departmentNo;
  private String departmentName;
  private int departmentHead;
  
  @Id
  @Column(name = "departmentNo")
  public int getDepartmentNo() {
    return departmentNo;
  }
  
  public void setDepartmentNo(int departmentNo) {
    this.departmentNo = departmentNo;
  }
  
  @Basic
  @Column(name = "departmentName")
  public String getDepartmentName() {
    return departmentName;
  }
  
  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }
  
  @Basic
  @Column(name = "departmentHead")
  public int getDepartmentHead() {
    return departmentHead;
  }
  
  public void setDepartmentHead(int departmentHead) {
    this.departmentHead = departmentHead;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DepartmentsinfoEntity that = (DepartmentsinfoEntity) o;
    return departmentNo == that.departmentNo &&
        Objects.equals(departmentName, that.departmentName) &&
        Objects.equals(departmentHead, that.departmentHead);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(departmentNo, departmentName, departmentHead);
  }
}

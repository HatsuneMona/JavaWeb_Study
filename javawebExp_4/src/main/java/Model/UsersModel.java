package Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "exp")
@IdClass(UsersModelPK.class)
public class UsersModel {
  
  private int userid;
  private String username;
  private String userpsw;
  private String userrole;
  
  @Id
  @Column(name = "userid", nullable = false)
  public int getUserid() {
    return userid;
  }
  
  public void setUserid(int userid) {
    this.userid = userid;
  }
  
  @Id
  @Column(name = "username", nullable = false, length = 30)
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  @Basic
  @Column(name = "userpsw", nullable = false, length = 30)
  public String getUserpsw() {
    return userpsw;
  }
  
  public void setUserpsw(String userpsw) {
    this.userpsw = userpsw;
  }
  
  @Basic
  @Column(name = "userrole", nullable = true, length = 10)
  public String getUserrole() {
    return userrole;
  }
  
  public void setUserrole(String userrole) {
    this.userrole = userrole;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    
    UsersModel that = (UsersModel) o;
    
    if (userid != that.userid) {
      return false;
    }
    if (username != null ? !username.equals(that.username) : that.username != null) {
      return false;
    }
    if (userpsw != null ? !userpsw.equals(that.userpsw) : that.userpsw != null) {
      return false;
    }
    if (userrole != null ? !userrole.equals(that.userrole) : that.userrole != null) {
      return false;
    }
    
    return true;
  }
  
  @Override
  public int hashCode() {
    int result = userid;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (userpsw != null ? userpsw.hashCode() : 0);
    result = 31 * result + (userrole != null ? userrole.hashCode() : 0);
    return result;
  }
  
  @Override
  public String toString() {
    return "User{" +
        "userid = " + userid +
        ",username = " + username +
        ",userrole = " + userrole +
        "}\n";
  }
}

package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

public class UsersModelPK implements Serializable {
  
  private int userid;
  private String username;
  
  @Column(name = "userid", nullable = false)
  @Id
  public int getUserid() {
    return userid;
  }
  
  public void setUserid(int userid) {
    this.userid = userid;
  }
  
  @Column(name = "username", nullable = false, length = 30)
  @Id
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    
    UsersModelPK that = (UsersModelPK) o;
    
    if (userid != that.userid) {
      return false;
    }
    if (username != null ? !username.equals(that.username) : that.username != null) {
      return false;
    }
    
    return true;
  }
  
  @Override
  public int hashCode() {
    int result = userid;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    return result;
  }
}

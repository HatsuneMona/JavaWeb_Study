package model;

import module.MD5;

/**
 * Created by Hatsune Mona on 2020/3/27. 初音萌奈什喵的最可爱了喵！
 */
public class UsersEntity {

  private String username;
  private String realname;
  private String sex;
  private String userpsw;
  private String schoolname;
  private String phonenum;
  private String dept;

  /**
   *
   */
  public UsersEntity() {
    super();
  }

  /**
   * @param username 用户名
   * @param realname 真实姓名
   * @param sex 性别
   * @param userpsw 密码
   * @param schoolname 学校名称
   * @param phonenum 手机
   * @param dept 系部
   */
  public UsersEntity(String username, String realname, String sex, String userpsw,
      String schoolname, String dept, String phonenum) {
    super();

    this.username = username;
    this.realname = realname;
    this.sex = sex;
    this.userpsw = MD5.GetMD5(userpsw);
    this.schoolname = schoolname;
    this.phonenum = phonenum;
    this.dept = dept;
  }

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return the realname
   */
  public String getRealname() {
    return realname;
  }

  /**
   * @param realname the realname to set
   */
  public void setRealname(String realname) {
    this.realname = realname;
  }

  /**
   * @return the sex
   */
  public String getSex() {
    return sex;
  }

  /**
   * @param sex the sex to set
   */
  public void setSex(String sex) {
    this.sex = sex;
  }

  /**
   * @return the userpsw
   */
  public String getUserpsw() {
    return userpsw;
  }

  /**
   * @param userpsw the userpsw to set
   */
  public void setUserpsw(String userpsw) {
    this.userpsw = userpsw;
  }

  /**
   * @return the schoolname
   */
  public String getSchoolname() {
    return schoolname;
  }

  /**
   * @param schoolname the schoolname to set
   */
  public void setSchoolname(String schoolname) {
    this.schoolname = schoolname;
  }

  /**
   * @return the mobile
   */
  public String getPhonenum() {
    return phonenum;
  }

  /**
   * @param mobile the mobile to set
   */
  public void setPhonenum(String mobile) {
    this.phonenum = mobile;
  }


  /**
   * @return the dept
   */
  public String getDept() {
    return dept;
  }

  /**
   * @param dept the dept to set
   */
  public void setDept(String dept) {
    this.dept = dept;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((phonenum == null) ? 0 : phonenum.hashCode());
    result = prime * result + ((realname == null) ? 0 : realname.hashCode());
    result = prime * result + ((schoolname == null) ? 0 : schoolname.hashCode());
    result = prime * result + ((sex == null) ? 0 : sex.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    result = prime * result + ((userpsw == null) ? 0 : userpsw.hashCode());
    result = prime * result + ((dept == null) ? 0 : dept.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    UsersEntity other = (UsersEntity) obj;
    if (phonenum == null) {
      if (other.phonenum != null) {
        return false;
      }
    } else if (!phonenum.equals(other.phonenum)) {
      return false;
    }
    if (realname == null) {
      if (other.realname != null) {
        return false;
      }
    } else if (!realname.equals(other.realname)) {
      return false;
    }
    if (schoolname == null) {
      if (other.schoolname != null) {
        return false;
      }
    } else if (!schoolname.equals(other.schoolname)) {
      return false;
    }
    if (sex == null) {
      if (other.sex != null) {
        return false;
      }
    } else if (!sex.equals(other.sex)) {
      return false;
    }
    if (username == null) {
      if (other.username != null) {
        return false;
      }
    } else if (!username.equals(other.username)) {
      return false;
    }
    if (userpsw == null) {
      if (other.userpsw != null) {
        return false;
      }
    } else if (!userpsw.equals(other.userpsw)) {
      return false;
    }
    if (dept == null) {
      if (other.dept != null) {
        return false;
      }
    } else if (!dept.equals(other.dept)) {
      return false;
    }
    return true;
  }
}

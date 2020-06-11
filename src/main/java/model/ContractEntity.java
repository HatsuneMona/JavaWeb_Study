package model;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contract", schema = "exp")
public class ContractEntity {
  
  private String contractid;
  private String contracttype;
  private Timestamp gatdate;
  private String lawer;
  private String operator;
  private String remark;
  
  @Id
  @Column(name = "contractid", nullable = false, length = 16)
  public String getContractid() {
    return contractid;
  }
  
  public void setContractid(String contractid) {
    this.contractid = contractid;
  }
  
  @Basic
  @Column(name = "contracttype", nullable = false, length = 10)
  public String getContracttype() {
    return contracttype;
  }
  
  public void setContracttype(String contracttype) {
    this.contracttype = contracttype;
  }
  
  @Basic
  @Column(name = "gatdate", nullable = true)
  public Timestamp getGatdate() {
    return gatdate;
  }
  
  public void setGatdate(Timestamp gatdate) {
    this.gatdate = gatdate;
  }
  
  @Basic
  @Column(name = "lawer", nullable = true, length = 10)
  public String getLawer() {
    return lawer;
  }
  
  public void setLawer(String lawer) {
    this.lawer = lawer;
  }
  
  @Basic
  @Column(name = "operator", nullable = true, length = 10)
  public String getOperator() {
    return operator;
  }
  
  public void setOperator(String operator) {
    this.operator = operator;
  }
  
  @Basic
  @Column(name = "remark", nullable = true, length = 500)
  public String getRemark() {
    return remark;
  }
  
  public void setRemark(String remark) {
    this.remark = remark;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContractEntity that = (ContractEntity) o;
    return Objects.equals(contractid, that.contractid) &&
        Objects.equals(contracttype, that.contracttype) &&
        Objects.equals(gatdate, that.gatdate) &&
        Objects.equals(lawer, that.lawer) &&
        Objects.equals(operator, that.operator) &&
        Objects.equals(remark, that.remark);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(contractid, contracttype, gatdate, lawer, operator, remark);
  }
}

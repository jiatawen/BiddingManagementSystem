package com.jiata.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
public class TUser implements Serializable {
    /**
     * 用户id
     */
    @TableId
    private Integer peopleId;

    /**
     * 用户类型
     */
    private String uType;

    /**
     * 法人名称
     */
    private String legalName;

    /**
     * 代理人名称
     */
    private String agentName;

    /**
     * 地址
     */
    private String place;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * 电话
     */
    private Integer phone;

    /**
     * 银行账户
     */
    private Integer bankId;

    /**
     * 开户行
     */
    private String bankPlace;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getPeopleId() {
        return peopleId;
    }

    /**
     * 
     */
    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    /**
     * 
     */
    public String getuType() {
        return uType;
    }

    /**
     * 
     */
    public void setuType(String uType) {
        this.uType = uType;
    }

    /**
     * 
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * 
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    /**
     * 
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * 
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * 
     */
    public String getPlace() {
        return place;
    }

    /**
     * 
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * 
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * 
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * 
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * 
     */
    public Integer getBankId() {
        return bankId;
    }

    /**
     * 
     */
    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    /**
     * 
     */
    public String getBankPlace() {
        return bankPlace;
    }

    /**
     * 
     */
    public void setBankPlace(String bankPlace) {
        this.bankPlace = bankPlace;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TUser other = (TUser) that;
        return (this.getPeopleId() == null ? other.getPeopleId() == null : this.getPeopleId().equals(other.getPeopleId()))
            && (this.getuType() == null ? other.getuType() == null : this.getuType().equals(other.getuType()))
            && (this.getLegalName() == null ? other.getLegalName() == null : this.getLegalName().equals(other.getLegalName()))
            && (this.getAgentName() == null ? other.getAgentName() == null : this.getAgentName().equals(other.getAgentName()))
            && (this.getPlace() == null ? other.getPlace() == null : this.getPlace().equals(other.getPlace()))
            && (this.getZipcode() == null ? other.getZipcode() == null : this.getZipcode().equals(other.getZipcode()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getBankId() == null ? other.getBankId() == null : this.getBankId().equals(other.getBankId()))
            && (this.getBankPlace() == null ? other.getBankPlace() == null : this.getBankPlace().equals(other.getBankPlace()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPeopleId() == null) ? 0 : getPeopleId().hashCode());
        result = prime * result + ((getuType() == null) ? 0 : getuType().hashCode());
        result = prime * result + ((getLegalName() == null) ? 0 : getLegalName().hashCode());
        result = prime * result + ((getAgentName() == null) ? 0 : getAgentName().hashCode());
        result = prime * result + ((getPlace() == null) ? 0 : getPlace().hashCode());
        result = prime * result + ((getZipcode() == null) ? 0 : getZipcode().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getBankId() == null) ? 0 : getBankId().hashCode());
        result = prime * result + ((getBankPlace() == null) ? 0 : getBankPlace().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", peopleId=").append(peopleId);
        sb.append(", uType=").append(uType);
        sb.append(", legalName=").append(legalName);
        sb.append(", agentName=").append(agentName);
        sb.append(", place=").append(place);
        sb.append(", zipcode=").append(zipcode);
        sb.append(", phone=").append(phone);
        sb.append(", bankId=").append(bankId);
        sb.append(", bankPlace=").append(bankPlace);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.jiata.contract;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_contract
 */
@TableName(value ="t_contract")
public class TContract implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer contractId;

    /**
     * 
     */
    private Integer partyAId;

    /**
     * 
     */
    private Integer partyBId;

    /**
     * 
     */
    private Date createDate;

    /**
     * 
     */
    private Date modifyDate;

    /**
     * 
     */
    private Date endDate;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String place;

    /**
     * 
     */
    private String scale;

    /**
     * 
     */
    private String clause;

    /**
     * 
     */
    private String breach;

    /**
     * 
     */
    private String supplement;

    /**
     * 
     */
    private Double uAMoney;

    /**
     * 
     */
    private Date uATime;

    /**
     * 
     */
    private String uBPower;

    /**
     * 
     */
    private String uBObligation;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getContractId() {
        return contractId;
    }

    /**
     * 
     */
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    /**
     * 
     */
    public Integer getPartyAId() {
        return partyAId;
    }

    /**
     * 
     */
    public void setPartyAId(Integer partyAId) {
        this.partyAId = partyAId;
    }

    /**
     * 
     */
    public Integer getPartyBId() {
        return partyBId;
    }

    /**
     * 
     */
    public void setPartyBId(Integer partyBId) {
        this.partyBId = partyBId;
    }

    /**
     * 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * 
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * 
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     */
    public void setName(String name) {
        this.name = name;
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
    public String getScale() {
        return scale;
    }

    /**
     * 
     */
    public void setScale(String scale) {
        this.scale = scale;
    }

    /**
     * 
     */
    public String getClause() {
        return clause;
    }

    /**
     * 
     */
    public void setClause(String clause) {
        this.clause = clause;
    }

    /**
     * 
     */
    public String getBreach() {
        return breach;
    }

    /**
     * 
     */
    public void setBreach(String breach) {
        this.breach = breach;
    }

    /**
     * 
     */
    public String getSupplement() {
        return supplement;
    }

    /**
     * 
     */
    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    /**
     * 
     */
    public Double getuAMoney() {
        return uAMoney;
    }

    /**
     * 
     */
    public void setuAMoney(Double uAMoney) {
        this.uAMoney = uAMoney;
    }

    /**
     * 
     */
    public Date getuATime() {
        return uATime;
    }

    /**
     * 
     */
    public void setuATime(Date uATime) {
        this.uATime = uATime;
    }

    /**
     * 
     */
    public String getuBPower() {
        return uBPower;
    }

    /**
     * 
     */
    public void setuBPower(String uBPower) {
        this.uBPower = uBPower;
    }

    /**
     * 
     */
    public String getuBObligation() {
        return uBObligation;
    }

    /**
     * 
     */
    public void setuBObligation(String uBObligation) {
        this.uBObligation = uBObligation;
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
        TContract other = (TContract) that;
        return (this.getContractId() == null ? other.getContractId() == null : this.getContractId().equals(other.getContractId()))
            && (this.getPartyAId() == null ? other.getPartyAId() == null : this.getPartyAId().equals(other.getPartyAId()))
            && (this.getPartyBId() == null ? other.getPartyBId() == null : this.getPartyBId().equals(other.getPartyBId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPlace() == null ? other.getPlace() == null : this.getPlace().equals(other.getPlace()))
            && (this.getScale() == null ? other.getScale() == null : this.getScale().equals(other.getScale()))
            && (this.getClause() == null ? other.getClause() == null : this.getClause().equals(other.getClause()))
            && (this.getBreach() == null ? other.getBreach() == null : this.getBreach().equals(other.getBreach()))
            && (this.getSupplement() == null ? other.getSupplement() == null : this.getSupplement().equals(other.getSupplement()))
            && (this.getuAMoney() == null ? other.getuAMoney() == null : this.getuAMoney().equals(other.getuAMoney()))
            && (this.getuATime() == null ? other.getuATime() == null : this.getuATime().equals(other.getuATime()))
            && (this.getuBPower() == null ? other.getuBPower() == null : this.getuBPower().equals(other.getuBPower()))
            && (this.getuBObligation() == null ? other.getuBObligation() == null : this.getuBObligation().equals(other.getuBObligation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getContractId() == null) ? 0 : getContractId().hashCode());
        result = prime * result + ((getPartyAId() == null) ? 0 : getPartyAId().hashCode());
        result = prime * result + ((getPartyBId() == null) ? 0 : getPartyBId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPlace() == null) ? 0 : getPlace().hashCode());
        result = prime * result + ((getScale() == null) ? 0 : getScale().hashCode());
        result = prime * result + ((getClause() == null) ? 0 : getClause().hashCode());
        result = prime * result + ((getBreach() == null) ? 0 : getBreach().hashCode());
        result = prime * result + ((getSupplement() == null) ? 0 : getSupplement().hashCode());
        result = prime * result + ((getuAMoney() == null) ? 0 : getuAMoney().hashCode());
        result = prime * result + ((getuATime() == null) ? 0 : getuATime().hashCode());
        result = prime * result + ((getuBPower() == null) ? 0 : getuBPower().hashCode());
        result = prime * result + ((getuBObligation() == null) ? 0 : getuBObligation().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contractId=").append(contractId);
        sb.append(", partyAId=").append(partyAId);
        sb.append(", partyBId=").append(partyBId);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", title=").append(title);
        sb.append(", name=").append(name);
        sb.append(", place=").append(place);
        sb.append(", scale=").append(scale);
        sb.append(", clause=").append(clause);
        sb.append(", breach=").append(breach);
        sb.append(", supplement=").append(supplement);
        sb.append(", uAMoney=").append(uAMoney);
        sb.append(", uATime=").append(uATime);
        sb.append(", uBPower=").append(uBPower);
        sb.append(", uBObligation=").append(uBObligation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
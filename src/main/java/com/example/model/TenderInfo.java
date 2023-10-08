package com.example.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class TenderInfo {
    private int id;//主键
    private String no;//投标编号
    private String company;//投标单位
    private String principal;//投标负责人
    private String projectId;//项目编号
    private String FinishDate;//完成日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime OpDate;//填报日期
    private String Userid;//填报人
    private String file;//附件
    private String comment;//备注

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getFinishDate() {
        return FinishDate;
    }

    public void setFinishDate(String finishDate) {
        FinishDate = finishDate;
    }

    public LocalDateTime getOpDate() {
        return OpDate;
    }

    public void setOpDate(LocalDateTime opDate) {
        OpDate = opDate;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

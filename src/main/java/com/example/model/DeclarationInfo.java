package com.example.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class DeclarationInfo {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime applydate;
    private String Projectname;
    private String Projectcontent;
    private String Projectno;
    private String Invitationtype;
    private LocalDateTime Finishdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getApplydate() {
        return applydate;
    }

    public void setApplydate(LocalDateTime applydate) {
        this.applydate = applydate;
    }

    public String getProjectname() {
        return Projectname;
    }

    public void setProjectname(String projectname) {
        Projectname = projectname;
    }

    public String getProjectcontent() {
        return Projectcontent;
    }

    public void setProjectcontent(String projectcontent) {
        Projectcontent = projectcontent;
    }

    public String getProjectno() {
        return Projectno;
    }

    public void setProjectno(String projectno) {
        Projectno = projectno;
    }

    public String getInvitationtype() {
        return Invitationtype;
    }

    public void setInvitationtype(String invitationtype) {
        Invitationtype = invitationtype;
    }

    public LocalDateTime getFinishdate() {
        return Finishdate;
    }

    public void setFinishdate(LocalDateTime finishdate) {
        Finishdate = finishdate;
    }
}

package com.gxu.yueread.entity;

import java.io.Serializable;

public class Admin implements Serializable {
    private Integer adminId;

    private String adminUsername;

    private String adminPassword;

    private String adminNickname;

    private static final long serialVersionUID = 1L;

    public Admin(String adminUsername, String adminPassword, String adminNickname) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.adminNickname = adminNickname;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminNickname() {
        return adminNickname;
    }

    public void setAdminNickname(String adminNickname) {
        this.adminNickname = adminNickname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", adminUsername=").append(adminUsername);
        sb.append(", adminPassword=").append(adminPassword);
        sb.append(", adminNickname=").append(adminNickname);
        sb.append("]");
        return sb.toString();
    }
}
package com.gxu.yueread.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;

    private String userUsername;

    private String userPassword;



    private String userNickname;

    private Integer userVip;

    private static final long serialVersionUID = 1L;

    public User(Integer userId, String userUsername, String userPassword, String userNickname) {
        this.userId = userId;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
    }

    public User(String userUsername, String userPassword, String userNickname) {
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
    }

    public User(Integer userId, String userUsername, String userPassword, String userNickname, Integer userVip) {
        this.userId = userId;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.userVip = userVip;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public Integer getUserVip() {
        return userVip;
    }

    public void setUserVip(Integer userVip) {
        this.userVip = userVip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userUsername=").append(userUsername);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userNickname=").append(userNickname);
        sb.append(", userVip=").append(userVip);
        sb.append("]");
        return sb.toString();
    }
}
package com.gxu.yueread.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;

    private String userUsername;

    private String userPassword;

    private String userNickname;

    private String userIntroduceSign;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

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

    public String getUserIntroduceSign() {
        return userIntroduceSign;
    }

    public void setUserIntroduceSign(String userIntroduceSign) {
        this.userIntroduceSign = userIntroduceSign;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
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
        sb.append(", userIntroduceSign=").append(userIntroduceSign);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}
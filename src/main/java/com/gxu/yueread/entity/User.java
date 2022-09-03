package com.gxu.yueread.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
    private Integer userId;

    private String userUsername;

    private String userPassword;

    private String userNickname;

    private Integer userVip;

    private static final long serialVersionUID = 1L;


}
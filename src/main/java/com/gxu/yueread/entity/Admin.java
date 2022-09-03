package com.gxu.yueread.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Admin implements Serializable {
    private Integer adminId;

    private String adminUsername;

    private String adminPassword;

    private String adminNickname;

    private static final long serialVersionUID = 1L;


}
package com.gxu.yueread.controller.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminParam implements Serializable {
    private Integer adminId;
    private String adminUsername;
    private String adminPassword;
    private String adminNickname;
}

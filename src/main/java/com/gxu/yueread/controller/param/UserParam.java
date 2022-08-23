package com.gxu.yueread.controller.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserParam implements Serializable {
    private Integer userId;
    private String userUsername;
    private String userPassword;
    private String userNickname;
    private Integer userVip;
}

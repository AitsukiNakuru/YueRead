package com.gxu.yueread.controller.admin.param;

import lombok.Data;

import java.io.Serializable;
@Data
public class AdminUpdateParam implements Serializable {
    String adminUsername;
    String adminPassword;
    String adminNickname;
    Integer originalId;
}

package com.gxu.yueread.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class User implements Serializable {
    private Integer userId;

    private String userUsername;

    private String userPassword;

    private String userNickname;

    private BigDecimal userPurchase;

    private Integer userVip;

    private static final long serialVersionUID = 1L;


}
package com.gxu.yueread.entity;

import lombok.Data;

import java.util.List;

@Data
public class CartItemBook {
    private Integer cartItemId;
    private Integer userId;
    private Integer bookCount;
    private BookInfo bookInfo;
}


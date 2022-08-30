package com.gxu.yueread.entity;

import lombok.Data;

import java.util.List;

@Data
public class CartItemBook {
    private Integer cartItemBookId;
    private Integer userId;
    private Integer bookCount;
    private BookInfo bookInfo;
}


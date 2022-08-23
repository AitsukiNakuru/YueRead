package com.gxu.yueread.controller.param;

import lombok.Data;

@Data
public class CartItemParam {
    private Integer cartItemId;
    private Integer userId;
    private Integer bookId;
    private Integer bookCount;
}

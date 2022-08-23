package com.gxu.yueread.controller.param;

import lombok.Data;

@Data
public class CartItemListParam {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer userId;
}

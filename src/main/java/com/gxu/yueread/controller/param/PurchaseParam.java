package com.gxu.yueread.controller.param;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseParam {
    private Integer cartItemId;
    private Integer bookId;
    private Integer bookCount;
    private Integer userId;
    private BigDecimal price;
}

package com.gxu.yueread.entity;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class UserOrderListItemBook {
    BookInfo bookInfo;
    int bookCount;
    BigDecimal sellingPrice;
}

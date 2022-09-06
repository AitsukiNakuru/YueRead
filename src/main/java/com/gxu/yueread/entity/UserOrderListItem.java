package com.gxu.yueread.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class UserOrderListItem {
    String orderId;
    BigDecimal totalPrice;
    Date orderDate;
    int orderStatus;
    List<UserOrderListItemBook> bookList;
}

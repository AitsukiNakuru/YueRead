package com.gxu.yueread.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderListItem {
    User user;
    List<UserOrderListItem> userOrderList;
}

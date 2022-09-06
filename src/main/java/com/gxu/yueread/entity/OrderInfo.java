package com.gxu.yueread.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class OrderInfo implements Serializable {
    private String orderId;

    private Integer userId;

    private BigDecimal totalPrice;

    private Integer orderStatus;

    private Date orderDate;

    private static final long serialVersionUID = 1L;

    public OrderInfo(String orderId, Integer userId, BigDecimal totalPrice, Integer orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }
}
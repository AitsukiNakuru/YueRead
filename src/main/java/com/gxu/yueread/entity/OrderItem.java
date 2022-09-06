package com.gxu.yueread.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderItem implements Serializable {
    private Integer orderItemId;

    private String orderId;

    private Integer bookId;

    private BigDecimal sellingPrice;

    private Integer bookCount;

    private static final long serialVersionUID = 1L;

    public OrderItem(String orderId, Integer bookId, BigDecimal sellingPrice, Integer bookCount) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.sellingPrice = sellingPrice;
        this.bookCount = bookCount;
    }

    public OrderItem() {
    }
}
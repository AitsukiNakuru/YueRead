package com.gxu.yueread.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItem implements Serializable {
    private Integer orderItemId;

    private Integer orderId;

    private Integer bookId;

    private BigDecimal sellingPrice;

    private Integer bookCount;

    private static final long serialVersionUID = 1L;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderItemId=").append(orderItemId);
        sb.append(", orderId=").append(orderId);
        sb.append(", bookId=").append(bookId);
        sb.append(", sellingPrice=").append(sellingPrice);
        sb.append(", bookCount=").append(bookCount);
        sb.append("]");
        return sb.toString();
    }
}
package com.gxu.yueread.entity;

import java.io.Serializable;
import java.util.List;

public class CartItem implements Serializable {
    private Integer cartItemId;

    private Integer userId;

    private Integer bookId;

    private Integer bookCount;



    private static final long serialVersionUID = 1L;

    public CartItem(Integer cartItemId, Integer userId, Integer bookId, Integer bookCount) {
        this.cartItemId = cartItemId;
        this.userId = userId;
        this.bookId = bookId;
        this.bookCount = bookCount;
    }

    public CartItem() {

    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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
        sb.append(", cartItemId=").append(cartItemId);
        sb.append(", userId=").append(userId);
        sb.append(", bookId=").append(bookId);
        sb.append(", bookCount=").append(bookCount);
        sb.append("]");
        return sb.toString();
    }
}
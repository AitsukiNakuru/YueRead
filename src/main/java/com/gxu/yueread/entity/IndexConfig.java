package com.gxu.yueread.entity;

import java.io.Serializable;

public class IndexConfig implements Serializable {
    private Integer configId;

    private Integer configType;

    private Integer bookId;

    private static final long serialVersionUID = 1L;

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public Integer getConfigType() {
        return configType;
    }

    public void setConfigType(Integer configType) {
        this.configType = configType;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", configId=").append(configId);
        sb.append(", configType=").append(configType);
        sb.append(", bookId=").append(bookId);
        sb.append("]");
        return sb.toString();
    }
}
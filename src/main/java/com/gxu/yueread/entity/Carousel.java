package com.gxu.yueread.entity;

import java.io.Serializable;

public class Carousel implements Serializable {
    private Integer carouselId;

    private String carouselImg;

    private String carouselUrl;

    private Integer carouselRank;

    private static final long serialVersionUID = 1L;

    public Integer getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(Integer carouselId) {
        this.carouselId = carouselId;
    }

    public String getCarouselImg() {
        return carouselImg;
    }

    public void setCarouselImg(String carouselImg) {
        this.carouselImg = carouselImg;
    }

    public String getCarouselUrl() {
        return carouselUrl;
    }

    public void setCarouselUrl(String carouselUrl) {
        this.carouselUrl = carouselUrl;
    }

    public Integer getCarouselRank() {
        return carouselRank;
    }

    public void setCarouselRank(Integer carouselRank) {
        this.carouselRank = carouselRank;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carouselId=").append(carouselId);
        sb.append(", carouselImg=").append(carouselImg);
        sb.append(", carouselUrl=").append(carouselUrl);
        sb.append(", carouselRank=").append(carouselRank);
        sb.append("]");
        return sb.toString();
    }
}
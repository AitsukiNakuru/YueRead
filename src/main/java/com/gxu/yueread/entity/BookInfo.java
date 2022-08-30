package com.gxu.yueread.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BookInfo implements Serializable {
    private Integer bookId;

    private String bookName;

    private String bookIsbn;

    private String bookIntro;

    private String bookAuthor;

    private Integer bookCategoryId;

    private String bookCategoryName;

    private String bookCover;

    private String detailContent;

    private BigDecimal originalPrice;

    private Integer bookStatus;

    private String publisher;

    private Date publishDate;

    private static final long serialVersionUID = 1L;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Integer bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public String getBookCategoryName() {
        return bookCategoryName;
    }

    public void setBookCategoryName(String bookCategoryName) {
        this.bookCategoryName = bookCategoryName;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookId=").append(bookId);
        sb.append(", bookName=").append(bookName);
        sb.append(", bookIsbn=").append(bookIsbn);
        sb.append(", bookIntro=").append(bookIntro);
        sb.append(", bookAuthor=").append(bookAuthor);
        sb.append(", bookCategoryId=").append(bookCategoryId);
        sb.append(", bookCategoryName=").append(bookCategoryName);
        sb.append(", bookCover=").append(bookCover);
        sb.append(", detailContent=").append(detailContent);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", bookStatus=").append(bookStatus);
        sb.append(", publisher=").append(publisher);
        sb.append(", publishDate=").append(publishDate);
        sb.append("]");
        return sb.toString();
    }
}
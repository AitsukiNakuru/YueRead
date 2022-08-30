package com.gxu.yueread.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
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

    private Integer bookSale;

    private Integer bookStock;

    private Integer carousel;

    private static final long serialVersionUID = 1L;


}
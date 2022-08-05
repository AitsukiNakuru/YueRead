package com.gxu.yueread.controller.admin.param;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookAddParam {
    private String bookName;
    private String bookIsbn;
    private String bookIntro;
    private String bookAuthor;
    private int bookCategoryId;
    private String bookCover;
    private String detailContent;
    private BigDecimal originalPrice;
    private int bookStatus;
    private String publisher;
    private Date publishDate;
}

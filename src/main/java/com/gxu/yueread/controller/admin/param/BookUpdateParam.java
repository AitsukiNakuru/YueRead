package com.gxu.yueread.controller.admin.param;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookUpdateParam {
    private Integer bookId;
    private String bookName;
    private String bookIsbn;
    private String bookIntro;
    private String bookAuthor;
    private Integer bookCategoryId;
    private String bookCover;
    private String detailContent;
    private BigDecimal originalPrice;
    private BigDecimal sellingPrice;
    private Integer bookStatus;
    private String publisher;
    private Date publishDate;
}

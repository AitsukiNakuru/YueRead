package com.gxu.yueread.controller.param;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookParam {
    private Integer bookId;
    private String bookName;
    private String bookIsbn;
    private String bookIntro;
    private String bookAuthor;
    private Integer bookCategoryId;
    private String bookCover;
    private String detailContent;
    private BigDecimal originalPrice;
    private Integer bookStatus;
    private String publisher;
    private Date publishDate;
}

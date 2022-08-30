package com.gxu.yueread.entity;

import lombok.Data;

import java.util.List;
//
@Data
public class BookListByCategory {
    private Integer categoryId;
    private String categoryName;
    private List<BookInfo> bookList;
}

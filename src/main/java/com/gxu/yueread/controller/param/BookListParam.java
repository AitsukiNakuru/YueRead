package com.gxu.yueread.controller.param;

import com.gxu.yueread.entity.BookInfo;
import lombok.Data;

@Data
public class BookListParam {
    private Integer pageNumber;
    private Integer pageSize;
    private String orderBy;
    private BookInfo bookInfo;
}

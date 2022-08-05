package com.gxu.yueread.controller.admin.param;

import com.gxu.yueread.entity.BookInfo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookListParam {
    Integer pageNumber;
    Integer pageSize;
    String orderBy;
    BookInfo bookInfo;
}

package com.gxu.yueread.controller.admin;
import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.controller.admin.param.BookAddParam;
import com.gxu.yueread.controller.admin.param.BookListParam;
import com.gxu.yueread.controller.admin.param.BookUpdateParam;
import com.gxu.yueread.entity.BookInfo;
import com.gxu.yueread.service.BookCategoryService;
import com.gxu.yueread.service.BookInfoService;

import com.gxu.yueread.util.BeanUtil;
import com.gxu.yueread.util.PageQueryUtil;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/book")
public class BookInfoController {

    @Resource
    private BookInfoService bookInfoService;
    @Resource
    private BookCategoryService bookCategoryService;

    private static final Logger logger = LoggerFactory.getLogger(BookInfoController.class);

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @RequestMapping("/selectOne")
    public BookInfo selectOne(Integer id) {
        return bookInfoService.selectByPrimaryKey(id);
    }

    @RequestMapping("/list")
    public Result bookList(@RequestBody BookListParam bookListParam) {
        Map<String, Object> queryParam = BeanUtil.toMap(bookListParam.getBookInfo());
        queryParam.put("page", bookListParam.getPageNumber());
        queryParam.put("limit", bookListParam.getPageSize());

        PageQueryUtil pageQueryUtil = new PageQueryUtil(queryParam);
        return ResultGenerator.genSuccessResult(bookInfoService.bookList(pageQueryUtil));


    }

    @RequestMapping("/add")
    public Result bookAdd(@RequestBody BookAddParam bookAddParam) {
        BookInfo bookInfo = new BookInfo();
        BeanUtil.copyProperties(bookAddParam, bookInfo);
        String bookAddResult = bookInfoService.bookAdd(bookInfo);
        if (bookAddResult.equals(ResultEnum.ADD_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(bookAddResult);
        }
        return ResultGenerator.genFailResult(bookAddResult);
    }

    @RequestMapping("/update")
    public Result bookUpdate(@RequestBody BookUpdateParam bookUpdateParam) {
        BookInfo bookInfo = new BookInfo();
        BeanUtil.copyProperties(bookUpdateParam, bookInfo);
        String bookUpdateResult = bookInfoService.bookUpdate(bookInfo);
        if (bookUpdateResult.equals(ResultEnum.UPDATE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(bookUpdateResult);
        }
        return ResultGenerator.genFailResult(bookUpdateResult);
    }

}

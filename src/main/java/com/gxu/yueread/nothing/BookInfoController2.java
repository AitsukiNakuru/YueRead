package com.gxu.yueread.controller.admin;

import com.gxu.yueread.common.Constants;
import com.gxu.yueread.common.ServiceResultEnum;
import com.gxu.yueread.controller.admin.param.BatchIdParam;
import com.gxu.yueread.controller.admin.param.BookAddParam;
import com.gxu.yueread.controller.admin.param.BookListParam;
import com.gxu.yueread.controller.admin.param.BookUpdateParam;
import com.gxu.yueread.entity.AdminToken;
import com.gxu.yueread.entity.BookInfo;
import com.gxu.yueread.service.admin.BookCategoryService;
import com.gxu.yueread.service.admin.BookInfoService;
import com.gxu.yueread.util.BeanUtil;
import com.gxu.yueread.util.PageQueryUtil;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (book_info)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/book")
public class BookInfoController {
    /**
     * 服务对象
     */
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
    @GetMapping("/selectOne")
    public BookInfo selectOne(Integer id) {
        return bookInfoService.selectByPrimaryKey(id);
    }

    @RequestMapping("/insert")
    public Result insert(@RequestBody BookAddParam bookAddParam, AdminToken adminToken) {
        logger.info("adminUser:{}", adminToken.toString());
        BookInfo bookInfo = new BookInfo();
        BeanUtil.copyProperties(bookAddParam, bookInfo);
        String result = bookInfoService.insertBook(bookInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    @RequestMapping("/list")
    public Result list(@RequestBody BookListParam bookListParam, AdminToken adminToken) {
        logger.info("adminUser:{}", adminToken.toString());
        Integer pageNumber = bookListParam.getPageNumber();//当前页码
        Integer pageSize = bookListParam.getPageSize();//每页大小
        if (pageNumber == null || pageNumber < 1 || pageSize == null || pageSize < 1) {
            return ResultGenerator.genFailResult("分页参数异常！");
        }
        Map params = new HashMap(8);
        params.put("page", pageNumber);
        params.put("limit", pageSize);

        PageQueryUtil pageQueryUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(bookInfoService.selectList(pageQueryUtil));
    }

    @RequestMapping("/update")
    public Result update(@RequestBody BookUpdateParam bookUpdateParam, AdminToken adminToken) {
        logger.info("adminUser:{}", adminToken.toString());
        BookInfo book = new BookInfo();
        BeanUtil.copyProperties(bookUpdateParam, book);
        String result = bookInfoService.updateBook(book);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    @RequestMapping("/delete")
    public Result modifyStatus(@RequestBody BatchIdParam batchIdParam, int bookStatus, AdminToken adminToken) {
        logger.info("adminUser:{}", adminToken.toString());
        if (batchIdParam == null || batchIdParam.getIds().length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (bookStatus != Constants.SELL_STATUS_UP && bookStatus != Constants.SELL_STATUS_DOWN) {
            return ResultGenerator.genFailResult("状态异常！");
        }
        if (bookInfoService.batchModifyBookStatus(batchIdParam.getIds(), bookStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

}

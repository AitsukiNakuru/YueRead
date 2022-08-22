package com.gxu.yueread.controller;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.controller.param.CategoryParam;
import com.gxu.yueread.entity.BookCategory;
import com.gxu.yueread.service.BookCategoryService;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (book_category)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/category")
public class BookCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private BookCategoryService bookCategoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public BookCategory selectOne(Integer id) {
        return bookCategoryService.selectByPrimaryKey(id);
    }


    //添加分类
    @RequestMapping("/add")
    public Result categoryAdd(@RequestBody CategoryParam categoryParam) {
        BookCategory bookCategory = new BookCategory();
        bookCategory.setCategoryName(categoryParam.getCategoryName());
        String categoryAddResult = bookCategoryService.bookCategoryAdd(bookCategory);

        if (categoryAddResult.equals(ResultEnum.ADD_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(categoryAddResult);
        }
        return ResultGenerator.genFailResult(categoryAddResult);
    }

    //删除分类
    @RequestMapping("/delete")
    public Result categoryDelete(@RequestBody CategoryParam categoryParam) {
        String categoryDeleteResult = bookCategoryService.bookCategoryDelete(categoryParam.getCategoryName());
        if (categoryDeleteResult.equals(ResultEnum.DELETE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(categoryDeleteResult);
        }
        return ResultGenerator.genFailResult(categoryDeleteResult);
    }

    //更新分类
    @RequestMapping("/update")
    public Result categoryUpdate(@RequestBody CategoryParam categoryParam) {
        String categoryUpdateResult = bookCategoryService.bookCategoryUpdate(categoryParam);
        if (categoryUpdateResult.equals(ResultEnum.UPDATE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(categoryUpdateResult);
        }
        return ResultGenerator.genFailResult(categoryUpdateResult);
    }

    //分类列表
    @RequestMapping("/list")
    public Result categoryList() {
        List<BookCategory>  categoryList = bookCategoryService.bookCategoryList();
        return ResultGenerator.genSuccessResult(categoryList);
    }

}

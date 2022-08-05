package com.gxu.yueread.controller.admin;
import com.gxu.yueread.entity.BookCategory;
import com.gxu.yueread.service.BookCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (book_category)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/book_category")
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
@GetMapping("selectOne")
public BookCategory selectOne(Integer id) {
return bookCategoryService.selectByPrimaryKey(id);
}

}

package com.gxu.yueread.controller.admin;
import com.gxu.yueread.entity.BookInfo;
import com.gxu.yueread.service.admin.BookInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (book_info)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/book_info")
public class BookInfoController {
/**
* 服务对象
*/
@Resource
private BookInfoService bookInfoService;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("selectOne")
public BookInfo selectOne(Integer id) {
return bookInfoService.selectByPrimaryKey(id);
}

}

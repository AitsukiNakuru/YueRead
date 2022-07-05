package com.gxu.yueread.controller.admin;
import com.gxu.yueread.entity.CartItem;
import com.gxu.yueread.service.admin.CartItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (cart_item)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/cart_item")
public class CartItemController {
/**
* 服务对象
*/
@Resource
private CartItemService cartItemService;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("selectOne")
public CartItem selectOne(Integer id) {
return cartItemService.selectByPrimaryKey(id);
}

}

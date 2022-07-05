package com.gxu.yueread.controller.admin;
import com.gxu.yueread.entity.OrderItem;
import com.gxu.yueread.service.admin.OrderItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (order_item)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/order_item")
public class OrderItemController {
/**
* 服务对象
*/
@Resource
private OrderItemService orderItemService;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("selectOne")
public OrderItem selectOne(Integer id) {
return orderItemService.selectByPrimaryKey(id);
}

}

package com.gxu.yueread.controller.admin;
import com.gxu.yueread.entity.OrderInfo;
import com.gxu.yueread.service.admin.OrderInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (order_info)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/order_info")
public class OrderInfoController {
/**
* 服务对象
*/
@Resource
private OrderInfoService orderInfoService;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("selectOne")
public OrderInfo selectOne(Integer id) {
return orderInfoService.selectByPrimaryKey(id);
}

}

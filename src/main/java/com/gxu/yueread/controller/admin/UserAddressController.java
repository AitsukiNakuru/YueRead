package com.gxu.yueread.controller.admin;
import com.gxu.yueread.entity.UserAddress;
import com.gxu.yueread.service.admin.UserAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (user_address)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/user_address")
public class UserAddressController {
/**
* 服务对象
*/
@Resource
private UserAddressService userAddressService;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("selectOne")
public UserAddress selectOne(Integer id) {
return userAddressService.selectByPrimaryKey(id);
}

}

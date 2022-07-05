package com.gxu.yueread.controller.admin;
import com.gxu.yueread.entity.Admin;
import com.gxu.yueread.service.admin.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (admin)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/admin")
public class AdminController {
/**
* 服务对象
*/
@Resource
private AdminService adminService;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("selectOne")
public Admin selectOne(Integer id) {
return adminService.selectByPrimaryKey(id);
}

}

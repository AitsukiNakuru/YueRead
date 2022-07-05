package com.gxu.yueread.controller.admin;
import com.gxu.yueread.entity.AdminToken;
import com.gxu.yueread.service.admin.AdminTokenService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (admin_token)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/admin_token")
public class AdminTokenController {
/**
* 服务对象
*/
@Resource
private AdminTokenService adminTokenService;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("selectOne")
public AdminToken selectOne(Integer id) {
return adminTokenService.selectByPrimaryKey(id);
}

}

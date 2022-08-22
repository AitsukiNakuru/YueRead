package com.gxu.yueread.controller;
import com.gxu.yueread.entity.IndexConfig;
import com.gxu.yueread.service.IndexConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (index_config)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/index_config")
public class IndexConfigController {
/**
* 服务对象
*/
@Resource
private IndexConfigService indexConfigService;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("selectOne")
public IndexConfig selectOne(Integer id) {
return indexConfigService.selectByPrimaryKey(id);
}

}

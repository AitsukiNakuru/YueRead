package com.gxu.yueread.controller.admin;
import com.gxu.yueread.entity.Carousel;
import com.gxu.yueread.service.admin.CarouselService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (carousel)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/carousel")
public class CarouselController {
/**
* 服务对象
*/
@Resource
private CarouselService carouselService;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("selectOne")
public Carousel selectOne(Integer id) {
return carouselService.selectByPrimaryKey(id);
}

}

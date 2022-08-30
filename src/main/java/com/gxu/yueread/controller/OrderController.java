package com.gxu.yueread.controller;

import com.gxu.yueread.entity.IndexConfig;
import com.gxu.yueread.service.OrderInfoService;
import com.gxu.yueread.service.OrderItemService;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderInfoService orderInfoService;

    @Resource
    private OrderItemService orderItemService;

    



}

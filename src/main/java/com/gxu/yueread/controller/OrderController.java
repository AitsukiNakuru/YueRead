package com.gxu.yueread.controller;

import com.gxu.yueread.service.OrderInfoService;
import com.gxu.yueread.service.OrderItemService;
import com.gxu.yueread.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderInfoService orderInfoService;

    @Resource
    private OrderItemService orderItemService;




}

package com.gxu.yueread.controller;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.entity.OrderInfo;
import com.gxu.yueread.entity.OrderListItem;
import com.gxu.yueread.entity.UserOrderListItem;
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
    private OrderItemService orderItemService;

    @Resource
    private OrderInfoService orderInfoService;


    @RequestMapping("/listall")
    public Result orderListAll() {
        List<OrderListItem> list =  orderInfoService.orderListAll();
        return ResultGenerator.genSuccessResult(list);
    }

    @RequestMapping("/refund")
    public Result orderRefund(@RequestBody OrderInfo orderInfo) {
        String orderRefundResult = orderInfoService.orderRefund(orderInfo);
        if (orderRefundResult.equals(ResultEnum.REFUND_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(orderRefundResult);
        }
        return ResultGenerator.genFailResult(orderRefundResult);
    }

    @RequestMapping("/listbyuser")
    public Result orderListByUser(@RequestBody OrderInfo orderInfo) {
        List<UserOrderListItem> list = orderInfoService.orderListByUser(orderInfo.getUserId());
        return ResultGenerator.genSuccessResult(list);
    }
}

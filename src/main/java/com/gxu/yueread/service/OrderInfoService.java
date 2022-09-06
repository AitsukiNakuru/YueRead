package com.gxu.yueread.service;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.dao.BookInfoMapper;
import com.gxu.yueread.dao.UserMapper;
import com.gxu.yueread.entity.OrderItem;
import com.gxu.yueread.entity.OrderListItem;
import com.gxu.yueread.entity.UserOrderListItem;
import com.gxu.yueread.util.ResultGenerator;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.OrderInfo;
import com.gxu.yueread.dao.OrderInfoMapper;

import java.util.List;

@Service
public class OrderInfoService{

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private BookInfoMapper bookInfoMapper;

    @Resource
    private UserMapper userMapper;

    
    public int deleteByPrimaryKey(String orderId) {
        return orderInfoMapper.deleteByPrimaryKey(orderId);
    }

    
    public int insert(OrderInfo record) {
        return orderInfoMapper.insert(record);
    }

    
    public int insertSelective(OrderInfo record) {
        return orderInfoMapper.insertSelective(record);
    }

    
    public OrderInfo selectByPrimaryKey(String orderId) {
        return orderInfoMapper.selectByPrimaryKey(orderId);
    }

    
    public int updateByPrimaryKeySelective(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKey(record);
    }

    public List<OrderListItem> orderListAll() {
        return orderInfoMapper.orderListAll();
    }

    public String orderRefund(OrderInfo orderInfo) {
        List<OrderItem> orderItemList = orderInfoMapper.selectOrderItemListByPrimaryKey(orderInfo.getOrderId());
        for (OrderItem orderItem : orderItemList) {
            bookInfoMapper.bookRefund(orderItem);
        }
        userMapper.orderRefund(orderInfo);

        orderInfoMapper.orderRefund(orderInfo);
        return ResultEnum.REFUND_SUCCESS.getResult();
    }

    public List<UserOrderListItem> orderListByUser(Integer userId) {
        List<UserOrderListItem> list = orderInfoMapper.orderListByUser(userId);
        return list;
    }
}

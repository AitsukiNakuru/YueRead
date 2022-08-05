package com.gxu.yueread.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.OrderItem;
import com.gxu.yueread.dao.OrderItemMapper;

@Service
public class OrderItemService {

    @Resource
    private OrderItemMapper orderItemMapper;


    public int deleteByPrimaryKey(Integer orderItemId) {
        return orderItemMapper.deleteByPrimaryKey(orderItemId);
    }


    public int insert(OrderItem record) {
        return orderItemMapper.insert(record);
    }


    public int insertSelective(OrderItem record) {
        return orderItemMapper.insertSelective(record);
    }


    public OrderItem selectByPrimaryKey(Integer orderItemId) {
        return orderItemMapper.selectByPrimaryKey(orderItemId);
    }


    public int updateByPrimaryKeySelective(OrderItem record) {
        return orderItemMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(OrderItem record) {
        return orderItemMapper.updateByPrimaryKey(record);
    }

}


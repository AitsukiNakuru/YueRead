package com.gxu.yueread.service.admin;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.OrderInfo;
import com.gxu.yueread.dao.admin.OrderInfoMapper;
@Service
public class OrderInfoService{

    @Resource
    private OrderInfoMapper orderInfoMapper;

    
    public int deleteByPrimaryKey(Integer orderId) {
        return orderInfoMapper.deleteByPrimaryKey(orderId);
    }

    
    public int insert(OrderInfo record) {
        return orderInfoMapper.insert(record);
    }

    
    public int insertSelective(OrderInfo record) {
        return orderInfoMapper.insertSelective(record);
    }

    
    public OrderInfo selectByPrimaryKey(Integer orderId) {
        return orderInfoMapper.selectByPrimaryKey(orderId);
    }

    
    public int updateByPrimaryKeySelective(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKey(record);
    }

}

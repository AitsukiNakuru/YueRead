package com.gxu.yueread.dao;

import com.gxu.yueread.entity.OrderInfo;
import com.gxu.yueread.entity.OrderItem;
import com.gxu.yueread.entity.OrderListItem;
import com.gxu.yueread.entity.UserOrderListItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderInfoMapper {
    /**
     * delete by primary key
     * @param orderId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(OrderInfo record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(OrderInfo record);

    /**
     * select by primary key
     * @param orderId primary key
     * @return object by primary key
     */
    OrderInfo selectByPrimaryKey(String orderId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OrderInfo record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OrderInfo record);

    List<OrderListItem> orderListAll();

    List<OrderItem> selectOrderItemListByPrimaryKey(@Param("orderId") String orderId);

    int orderRefund(OrderInfo orderInfo);

    List<UserOrderListItem> orderListByUser(@Param("userId") Integer userId);

}
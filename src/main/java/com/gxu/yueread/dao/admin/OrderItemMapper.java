package com.gxu.yueread.dao.admin;

import com.gxu.yueread.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper {
    /**
     * delete by primary key
     *
     * @param orderItemId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer orderItemId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(OrderItem record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(OrderItem record);

    /**
     * select by primary key
     *
     * @param orderItemId primary key
     * @return object by primary key
     */
    OrderItem selectByPrimaryKey(Integer orderItemId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OrderItem record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OrderItem record);
}
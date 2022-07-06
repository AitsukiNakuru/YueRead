package com.gxu.yueread.dao.admin;

import com.gxu.yueread.entity.CartItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartItemMapper {
    /**
     * delete by primary key
     *
     * @param cartItemId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer cartItemId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(CartItem record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CartItem record);

    /**
     * select by primary key
     *
     * @param cartItemId primary key
     * @return object by primary key
     */
    CartItem selectByPrimaryKey(Integer cartItemId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CartItem record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CartItem record);
}
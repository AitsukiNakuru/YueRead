package com.gxu.yueread.dao.admin;

import com.gxu.yueread.entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAddressMapper {
    /**
     * delete by primary key
     * @param addressId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer addressId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserAddress record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserAddress record);

    /**
     * select by primary key
     * @param addressId primary key
     * @return object by primary key
     */
    UserAddress selectByPrimaryKey(Integer addressId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserAddress record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserAddress record);
}
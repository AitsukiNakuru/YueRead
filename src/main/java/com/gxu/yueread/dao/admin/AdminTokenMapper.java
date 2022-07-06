package com.gxu.yueread.dao.admin;

import com.gxu.yueread.entity.AdminToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminTokenMapper {
    /**
     * delete by primary key
     *
     * @param adminId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer adminId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(AdminToken record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(AdminToken record);

    /**
     * select by primary key
     *
     * @param adminId primary key
     * @return object by primary key
     */
    AdminToken selectByPrimaryKey(Integer adminId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(AdminToken record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(AdminToken record);
}
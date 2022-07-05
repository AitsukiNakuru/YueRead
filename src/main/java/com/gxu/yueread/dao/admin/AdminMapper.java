package com.gxu.yueread.dao.admin;

import com.gxu.yueread.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    /**
     * delete by primary key
     * @param adminId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer adminId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Admin record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Admin record);

    /**
     * select by primary key
     * @param adminId primary key
     * @return object by primary key
     */
    Admin selectByPrimaryKey(Integer adminId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Admin record);
}
package com.gxu.yueread.dao;

import com.gxu.yueread.entity.BookInfo;
import com.gxu.yueread.entity.IndexConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IndexConfigMapper {
    /**
     * delete by primary key
     * @param configId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer configId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(IndexConfig record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(IndexConfig record);

    /**
     * select by primary key
     * @param configId primary key
     * @return object by primary key
     */
    IndexConfig selectByPrimaryKey(Integer configId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(IndexConfig record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(IndexConfig record);

    List<BookInfo> indexBookList();

    IndexConfig selectByBookId(@Param("bookId") Integer bookId);
}
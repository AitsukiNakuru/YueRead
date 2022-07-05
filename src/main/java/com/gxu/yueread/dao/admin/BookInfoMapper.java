package com.gxu.yueread.dao.admin;

import com.gxu.yueread.entity.BookInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookInfoMapper {
    /**
     * delete by primary key
     * @param bookId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer bookId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(BookInfo record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(BookInfo record);

    /**
     * select by primary key
     * @param bookId primary key
     * @return object by primary key
     */
    BookInfo selectByPrimaryKey(Integer bookId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BookInfo record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BookInfo record);
}
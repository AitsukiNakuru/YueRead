package com.gxu.yueread.dao;

import com.gxu.yueread.entity.BookCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookCategoryMapper {
    /**
     * delete by primary key
     * @param categoryId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer categoryId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(BookCategory record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(BookCategory record);

    /**
     * select by primary key
     * @param categoryId primary key
     * @return object by primary key
     */
    BookCategory selectByPrimaryKey(Integer categoryId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BookCategory record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BookCategory record);

    BookCategory selectByCategoryName(String categoryName);

    List<BookCategory> categoryList();
}
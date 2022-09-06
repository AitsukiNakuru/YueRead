package com.gxu.yueread.dao;

import com.gxu.yueread.controller.param.PurchaseParam;
import com.gxu.yueread.entity.BookInfo;
import com.gxu.yueread.entity.BookListByCategory;
import com.gxu.yueread.entity.OrderItem;
import com.gxu.yueread.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    /**
     * delete by primary key
     *
     * @param bookId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer bookId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(BookInfo record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BookInfo record);

    /**
     * select by primary key
     *
     * @param bookId primary key
     * @return object by primary key
     */
    BookInfo selectByPrimaryKey(Integer bookId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BookInfo record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BookInfo record);

    List<BookInfo> bookList(PageQueryUtil pageQueryUtil);

    int getTotalCount(PageQueryUtil pageQueryUtil);

    BookInfo selectByIsbn(@Param("bookIsbn") String bookIsbn);

    List<BookInfo> selectByCategoryId(@Param("categoryId") Integer categoryId);

    List<BookInfo> selectAll();

    List<BookListByCategory> selectListByCategory();

    List<BookInfo> selectListByCarousel();

    int purchaseBook(PurchaseParam purchaseParam);

    int bookRefund(OrderItem orderItem);

    List<BookInfo> selectAllUser();

    List<BookListByCategory> selectListByCategoryUser();
}
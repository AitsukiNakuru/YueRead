package com.gxu.yueread.service.admin;

import com.gxu.yueread.common.CategoryLevelEnum;
import com.gxu.yueread.common.ServiceResultEnum;
import com.gxu.yueread.dao.admin.BookCategoryMapper;
import com.gxu.yueread.entity.BookCategory;
import com.gxu.yueread.util.PageQueryUtil;
import com.gxu.yueread.util.PageResult;
import org.springframework.stereotype.Service;

import com.gxu.yueread.dao.admin.BookInfoMapper;
import com.gxu.yueread.entity.BookInfo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookInfoService{

    @Resource
    private BookInfoMapper bookInfoMapper;

    @Resource
    private BookCategoryMapper bookCategoryMapper;


    public int deleteByPrimaryKey(Integer bookId) {
        return bookInfoMapper.deleteByPrimaryKey(bookId);
    }


    public int insert(BookInfo record) {
        return bookInfoMapper.insert(record);
    }


    public int insertSelective(BookInfo record) {
        return bookInfoMapper.insertSelective(record);
    }


    public BookInfo selectByPrimaryKey(Integer bookId) {
        return bookInfoMapper.selectByPrimaryKey(bookId);
    }


    public int updateByPrimaryKeySelective(BookInfo record) {
        return bookInfoMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(BookInfo record) {
        return bookInfoMapper.updateByPrimaryKey(record);
    }

    public String insertBook(BookInfo book) {
        BookCategory bookCategory = bookCategoryMapper.selectByPrimaryKey(book.getBookCategoryId());

        if (bookCategory == null || bookCategory.getCategoryLevel() > CategoryLevelEnum.LEVEL_THREE.getLevel()) {

            return ServiceResultEnum.BOOK_CATEGORY_ERROR.getResult();
        }

        //如果数据库中有一本isbn与要插入的书的isbn相同，则说明数据库中有这本书，不插入
        if (bookInfoMapper.selectByBookIsbn(book.getBookIsbn()) != null) {
            return ServiceResultEnum.SAME_BOOK_EXIST.getResult();
        }

        if (bookInfoMapper.insertSelective(book) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }

        return ServiceResultEnum.DB_ERROR.getResult();
    }

    public PageResult selectList(PageQueryUtil pageQueryUtil) {
        List<BookInfo> bookList = bookInfoMapper.selectBookList(pageQueryUtil);
        int total = bookInfoMapper.getTotalBookCount(pageQueryUtil);
        PageResult pageResult = new PageResult(bookList, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
        return pageResult;
    }

    public String updateBook(BookInfo book) {
        BookCategory bookCategory = bookCategoryMapper.selectByPrimaryKey(book.getBookCategoryId());

        //判断分类是否合法
        if (bookCategory == null || bookCategory.getCategoryLevel() > CategoryLevelEnum.LEVEL_THREE.getLevel()) {
            return ServiceResultEnum.BOOK_CATEGORY_ERROR.getResult();
        }

        //判断修改目标是否存在
        BookInfo temp = bookInfoMapper.selectByPrimaryKey(book.getBookId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }

        if (bookInfoMapper.updateByPrimaryKeySelective(book) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    public boolean batchModifyBookStatus(Long[] ids, int bookStatus) {
        return bookInfoMapper.batchModifyBookStatus(ids, bookStatus) > 0;
    }
}

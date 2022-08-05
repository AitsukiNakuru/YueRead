package com.gxu.yueread.service;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.util.PageQueryUtil;
import com.gxu.yueread.util.PageResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.dao.BookInfoMapper;
import com.gxu.yueread.entity.BookInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookInfoService {

    @Resource
    private BookInfoMapper bookInfoMapper;


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

    public PageResult bookList(PageQueryUtil pageQueryUtil) {
        List<BookInfo> bookList = bookInfoMapper.bookList(pageQueryUtil);
        int total = bookInfoMapper.getTotalCount(pageQueryUtil);
        PageResult pageResult = new PageResult(bookList, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
        return pageResult;
    }

    public String bookAdd(BookInfo bookInfo) {
        if (bookInfoMapper.selectByIsbn(bookInfo.getBookIsbn()) !=null) {
            return ResultEnum.SAME_BOOK_EXIST.getResult();
        }
        if (bookInfoMapper.insertSelective(bookInfo) >= 1) {
            return ResultEnum.ADD_SUCCESS.getResult();
        }
        return ResultEnum.ADD_ERROR.getResult();
    }

    public String bookUpdate(BookInfo bookInfo) {
        if (bookInfoMapper.updateByPrimaryKeySelective(bookInfo) >= 1) {
            return ResultEnum.UPDATE_SUCCESS.getResult();
        }
        return ResultEnum.UPDATE_ERROR.getResult();
    }
}



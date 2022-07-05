package com.gxu.yueread.service.admin;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.dao.admin.BookInfoMapper;
import com.gxu.yueread.entity.BookInfo;
@Service
public class BookInfoService{

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

}

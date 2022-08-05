package com.gxu.yueread.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.dao.BookCategoryMapper;
import com.gxu.yueread.entity.BookCategory;

@Service
public class BookCategoryService {

    @Resource
    private BookCategoryMapper bookCategoryMapper;


    public int deleteByPrimaryKey(Integer categoryId) {
        return bookCategoryMapper.deleteByPrimaryKey(categoryId);
    }


    public int insert(BookCategory record) {
        return bookCategoryMapper.insert(record);
    }


    public int insertSelective(BookCategory record) {
        return bookCategoryMapper.insertSelective(record);
    }


    public BookCategory selectByPrimaryKey(Integer categoryId) {
        return bookCategoryMapper.selectByPrimaryKey(categoryId);
    }


    public int updateByPrimaryKeySelective(BookCategory record) {
        return bookCategoryMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(BookCategory record) {
        return bookCategoryMapper.updateByPrimaryKey(record);
    }

}


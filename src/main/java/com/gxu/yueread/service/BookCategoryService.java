package com.gxu.yueread.service;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.controller.param.CategoryParam;
import com.gxu.yueread.dao.BookInfoMapper;
import com.gxu.yueread.entity.BookInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.dao.BookCategoryMapper;
import com.gxu.yueread.entity.BookCategory;

import java.util.List;

@Service
public class BookCategoryService {

    @Resource
    private BookCategoryMapper bookCategoryMapper;

    @Resource
    private BookInfoMapper bookInfoMapper;


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

    public BookCategory selectByCategoryName(String categoryName) {
        return bookCategoryMapper.selectByCategoryName(categoryName);
    }

    public String bookCategoryAdd(BookCategory bookCategory) {
        if (bookCategoryMapper.selectByCategoryName(bookCategory.getCategoryName()) != null) {
            return ResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        if (bookCategoryMapper.insertSelective(bookCategory) >= 1) {
            return ResultEnum.ADD_SUCCESS.getResult();
        }
        return ResultEnum.ADD_ERROR.getResult();
    }

    public String bookCategoryDelete(Integer categoryId) {
        BookCategory bookCategory = bookCategoryMapper.selectByPrimaryKey(categoryId);

        if(bookInfoMapper.selectByCategoryId(categoryId).size() > 0) {
            return ResultEnum.CATEGORY_NOT_NULL.getResult();
        }
        if (bookCategory == null) {
            return ResultEnum.CATEGORY_NOT_EXIST.getResult();
        }
        if (bookCategoryMapper.deleteByPrimaryKey(bookCategory.getCategoryId()) >= 1) {
            return ResultEnum.DELETE_SUCCESS.getResult();
        }
        return ResultEnum.DELETE_ERROR.getResult();
    }

    public String bookCategoryUpdate(CategoryParam categoryParam) {
        BookCategory bookCategory = bookCategoryMapper.selectByPrimaryKey(categoryParam.getCategoryId());
        BookCategory newCategory = bookCategoryMapper.selectByCategoryName(categoryParam.getCategoryName());
        if (bookCategory == null) {
            return ResultEnum.CATEGORY_NOT_EXIST.getResult();
        }
        if ( newCategory != null && !newCategory.getCategoryName().equals(bookCategory.getCategoryName())) {
            return ResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        bookCategory.setCategoryName(categoryParam.getCategoryName());
        if (bookCategoryMapper.updateByPrimaryKeySelective(bookCategory) >= 1) {
            return ResultEnum.UPDATE_SUCCESS.getResult();
        }
        return ResultEnum.UPDATE_ERROR.getResult();
    }

    public List<BookCategory> bookCategoryList() {
        return bookCategoryMapper.categoryList();
    }
}


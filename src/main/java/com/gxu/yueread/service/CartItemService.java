package com.gxu.yueread.service;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.dao.BookInfoMapper;
import com.gxu.yueread.entity.BookInfo;
import com.gxu.yueread.entity.CartItemBook;
import com.gxu.yueread.util.PageQueryUtil;
import com.gxu.yueread.util.PageResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.CartItem;
import com.gxu.yueread.dao.CartItemMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class CartItemService {

    @Resource
    private CartItemMapper cartItemMapper;

    @Resource
    private BookInfoMapper bookInfoMapper;


    public int deleteByPrimaryKey(Integer cartItemId) {
        return cartItemMapper.deleteByPrimaryKey(cartItemId);
    }


    public int insert(CartItem record) {
        return cartItemMapper.insert(record);
    }


    public int insertSelective(CartItem record) {
        return cartItemMapper.insertSelective(record);
    }


    public CartItem selectByPrimaryKey(Integer cartItemId) {
        return cartItemMapper.selectByPrimaryKey(cartItemId);
    }


    public int updateByPrimaryKeySelective(CartItem record) {
        return cartItemMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(CartItem record) {
        return cartItemMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public String add(CartItem cartItem) {
        List<Integer> bookIds = cartItemMapper.getBookIds(cartItem.getUserId());
        BookInfo bookInfo = bookInfoMapper.selectByPrimaryKey(cartItem.getBookId());
        try {
            if (bookIds.contains(cartItem.getBookId())) {
                cartItemMapper.addBookCount(cartItem);
                if (cartItemMapper.selectByUserIdAndBookId(cartItem.getUserId(), cartItem.getBookId() ).getBookCount() > bookInfo.getBookStock()) {
                    throw new Exception("StockError");
                }
                return ResultEnum.ADD_SUCCESS.getResult();
            } else {
                if (cartItem.getBookCount() > bookInfoMapper.selectByPrimaryKey(cartItem.getBookId()).getBookStock()) {
                    return ResultEnum.STOCK_ERROR.getResult();
                }

                if (cartItemMapper.insertSelective(cartItem) >= 1) {
                    return ResultEnum.ADD_SUCCESS.getResult();
                }
            }
        } catch(Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultEnum.STOCK_ERROR.getResult();
        }
        return ResultEnum.ADD_ERROR.getResult();
    }

    public String update(CartItem cartItem) {
        if (cartItemMapper.update(cartItem) >= 1) {
            return ResultEnum.UPDATE_SUCCESS.getResult();
        }
        return ResultEnum.UPDATE_ERROR.getResult();
    }

    public String delete(CartItem cartItem) {
        if (cartItemMapper.deleteByPrimaryKey(cartItem.getCartItemId()) >= 1) {
            return ResultEnum.DELETE_SUCCESS.getResult();
        }
        return ResultEnum.DELETE_ERROR.getResult();
    }

    public List<CartItemBook> list(Integer userId) {

        return cartItemMapper.selectByUserId(userId);
    }
}


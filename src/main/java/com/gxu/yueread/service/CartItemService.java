package com.gxu.yueread.service;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.util.PageQueryUtil;
import com.gxu.yueread.util.PageResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.CartItem;
import com.gxu.yueread.dao.CartItemMapper;

import java.util.List;

@Service
public class CartItemService {

    @Resource
    private CartItemMapper cartItemMapper;


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

    public String add(CartItem cartItem) {
        List<Integer> bookIds = cartItemMapper.getBookIds(cartItem.getUserId());
        if (bookIds.contains(cartItem.getBookId())) {
            cartItemMapper.update(cartItem);
            return ResultEnum.ADD_SUCCESS.getResult();
        }
        if (cartItemMapper.insertSelective(cartItem) >= 1) {
            return ResultEnum.ADD_SUCCESS.getResult();
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

    public PageResult list(PageQueryUtil pageQueryUtil) {
        List<CartItem> list = cartItemMapper.list(pageQueryUtil);
        int total = cartItemMapper.getTotalCount(pageQueryUtil);
        PageResult pageResult = new PageResult<>(list, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
        return pageResult;
    }
}


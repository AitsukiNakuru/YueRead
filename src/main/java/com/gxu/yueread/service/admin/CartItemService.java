package com.gxu.yueread.service.admin;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.CartItem;
import com.gxu.yueread.dao.admin.CartItemMapper;
@Service
public class CartItemService{

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

}

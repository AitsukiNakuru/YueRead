package com.gxu.yueread.controller;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.entity.CartItem;
import com.gxu.yueread.entity.CartItemBook;
import com.gxu.yueread.service.CartItemService;
import com.gxu.yueread.service.UserService;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private CartItemService cartItemService;

    @Resource
    private UserService userService;

    //添加
    @RequestMapping("/add")
    public Result cartItemAdd(@RequestBody CartItem cartItem) {
        String cartItemAddResult = cartItemService.add(cartItem);
        if (cartItemAddResult.equals(ResultEnum.ADD_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(cartItemAddResult);
        }
        return ResultGenerator.genFailResult(cartItemAddResult);
    }

    //更新
    @RequestMapping("/update")
    public Result cartItemUpdate(@RequestBody CartItem cartItem) {
        String cartItemUpdateResult = cartItemService.update(cartItem);
        if (cartItemUpdateResult.equals(ResultEnum.UPDATE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(cartItemUpdateResult);
        }
        return ResultGenerator.genFailResult(cartItemUpdateResult);
    }

    //删除
    @RequestMapping("/delete")
    public Result cartItemDelete(@RequestBody CartItem cartItem) {
        String cartItemDeleteResult = cartItemService.delete(cartItem);
        if (cartItemDeleteResult.equals(ResultEnum.DELETE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(cartItemDeleteResult);
        }
        return ResultGenerator.genFailResult(cartItemDeleteResult);
    }

    //列表
    @RequestMapping("/list")
    public Result cartItemList(@RequestBody CartItem cartItem) {
        List<CartItemBook> cartItemList = cartItemService.list(cartItem.getUserId());
        return ResultGenerator.genSuccessResult(cartItemList);
    }
}

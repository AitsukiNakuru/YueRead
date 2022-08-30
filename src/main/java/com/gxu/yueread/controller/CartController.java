package com.gxu.yueread.controller;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.controller.param.CartItemListParam;
import com.gxu.yueread.controller.param.CartItemParam;
import com.gxu.yueread.entity.BookInfo;
import com.gxu.yueread.entity.CartItem;
import com.gxu.yueread.entity.CartItemBook;
import com.gxu.yueread.service.CartItemService;
import com.gxu.yueread.service.UserService;
import com.gxu.yueread.util.BeanUtil;
import com.gxu.yueread.util.PageQueryUtil;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private CartItemService cartItemService;

    @Resource
    private UserService userService;

    //添加
    @RequestMapping("/add")
    public Result cartItemAdd(@RequestBody CartItemParam cartItemParam) {
        String cartItemAddResult = cartItemService.add(new CartItem(cartItemParam.getCartItemId(), cartItemParam.getUserId(), cartItemParam.getBookId(), cartItemParam.getBookCount()));
        if (cartItemAddResult.equals(ResultEnum.ADD_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(cartItemAddResult);
        }
        return ResultGenerator.genFailResult(cartItemAddResult);
    }

    //更新
    @RequestMapping("/update")
    public Result cartItemUpdate(@RequestBody CartItemParam cartItemParam) {
        String cartItemUpdateResult = cartItemService.update(new CartItem(cartItemParam.getCartItemId(), cartItemParam.getUserId(), cartItemParam.getBookId(), cartItemParam.getBookCount()));
        if (cartItemUpdateResult.equals(ResultEnum.UPDATE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(cartItemUpdateResult);
        }
        return ResultGenerator.genFailResult(cartItemUpdateResult);
    }

    //删除
    @RequestMapping("/delete")
    public Result cartItemDelete(@RequestBody CartItemParam cartItemParam) {
        String cartItemDeleteResult = cartItemService.delete(new CartItem(cartItemParam.getCartItemId(), cartItemParam.getUserId(), cartItemParam.getBookId(), cartItemParam.getBookCount()));
        if (cartItemDeleteResult.equals(ResultEnum.DELETE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(cartItemDeleteResult);
        }
        return ResultGenerator.genFailResult(cartItemDeleteResult);
    }

    //列表
    @RequestMapping("/list")
    public Result cartItemList(@RequestBody CartItemParam cartItemParam) {
        List<CartItemBook> cartItemList = cartItemService.list(cartItemParam.getUserId());
        return ResultGenerator.genSuccessResult(cartItemList);
    }
}

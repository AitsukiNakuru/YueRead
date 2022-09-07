package com.gxu.yueread.service;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.controller.param.PurchaseParam;
import com.gxu.yueread.dao.*;
import com.gxu.yueread.entity.*;
import com.gxu.yueread.util.OrderGenerator;
import com.gxu.yueread.util.PageQueryUtil;
import com.gxu.yueread.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookInfoService {

    @Resource
    private BookInfoMapper bookInfoMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CartItemMapper cartItemMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Resource
    private OrderInfoMapper orderInfoMapper;


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
        if (bookInfoMapper.selectByIsbn(bookInfo.getBookIsbn()) != null) {
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

    public List<BookInfo> selectByCategoryId(Integer categoryId) {
        return bookInfoMapper.selectByCategoryId(categoryId);
    }

    public List<BookInfo> selectAll() {
        return bookInfoMapper.selectAll();
    }

    public List<BookListByCategory> selectListByCategory() {
        return bookInfoMapper.selectListByCategory();
    }

    public List<BookInfo> selectListByCarousel() {
        return bookInfoMapper.selectListByCarousel();
    }

    public String purchaseBook(PurchaseParam purchaseParam) {
        OrderInfo orderInfo = OrderGenerator.generateOrder(purchaseParam.getUserId(), purchaseParam.getTotalPrice());
        OrderItem orderItem = new OrderItem(orderInfo.getOrderId(), purchaseParam.getBookId(), purchaseParam.getPrice(), purchaseParam.getBookCount());
        BookInfo bookInfo = bookInfoMapper.selectByPrimaryKey(purchaseParam.getBookId());
        if (bookInfo.getBookStock() < purchaseParam.getBookCount()) {
            return ResultEnum.STOCK_ERROR.getResult();
        }
        if (bookInfoMapper.purchaseBook(purchaseParam) >= 1 &&
                userMapper.updatePurchase(purchaseParam) >= 1 &&
                orderInfoMapper.insertSelective(orderInfo) >=1 &&
                orderItemMapper.insertSelective(orderItem) >=1
        ) {
            return ResultEnum.PURCHASE_SUCCESS.getResult();
        }
        return ResultEnum.PURCHASE_ERROR.getResult();
    }

    public String purchaseList(List<PurchaseParam> purchaseParamList) {
        int count = 0;
        boolean flag = false;
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        //List<BookInfo> stockErrorBookList = new ArrayList<BookInfo>();
        for (PurchaseParam purchaseParam : purchaseParamList) {
            totalPrice = totalPrice.add(purchaseParam.getTotalPrice());
            BookInfo bookInfo = bookInfoMapper.selectByPrimaryKey(purchaseParam.getBookId());
            if (purchaseParam.getBookCount() > bookInfo.getBookStock()) {
                CartItem cartItem = new CartItem();
                cartItem.setCartItemId(purchaseParam.getCartItemId());
                cartItem.setBookCount(bookInfo.getBookStock());
                cartItemMapper.updateByPrimaryKeySelective(cartItem);
                flag = true;
            }
        }
        if (flag) {
            return ResultEnum.STOCK_ERROR.getResult();
        }

        OrderInfo orderInfo = OrderGenerator.generateOrder(purchaseParamList.get(0).getUserId(), totalPrice);
        orderInfoMapper.insertSelective(orderInfo);
        for (PurchaseParam purchaseParam : purchaseParamList) {
            OrderItem orderItem = new OrderItem(orderInfo.getOrderId(), purchaseParam.getBookId(), purchaseParam.getPrice(), purchaseParam.getBookCount());
            if (bookInfoMapper.purchaseBook(purchaseParam) >= 1 &&
                    userMapper.updatePurchase(purchaseParam) >= 1 &&
                    cartItemMapper.deleteByPrimaryKey(purchaseParam.getCartItemId()) >= 1 &&
                    orderItemMapper.insertSelective(orderItem) >= 1
            ) {
                count++;
            }
        }
        if (count == purchaseParamList.size()) {
            return ResultEnum.PURCHASE_SUCCESS.getResult();
        }
        return ResultEnum.PURCHASE_ERROR.getResult();

    }

    public List<BookInfo> selectAllUser() {
        return bookInfoMapper.selectAllUser();
    }

    public List<BookListByCategory> selectListByCategoryUser() {
        return bookInfoMapper.selectListByCategoryUser();
    }

    public List<BookInfo> hotSaleList() {
        return bookInfoMapper.hotSaleList();
    }
}



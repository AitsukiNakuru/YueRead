/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本软件已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2021 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package com.gxu.yueread.common;

public enum ResultEnum {
    ERROR("error"),

    SUCCESS("success"),

    LOGIN_ERROR("登录失败！"),

    LOGIN_SUCCESS("登陆成功"),

    USERNAME_NOT_EXIST("用户名不存在"),

    PASSWORD_ERROR("密码错误"),

    REGISTER_ERROR("注册失败！"),

    REGISTER_SUCCESS("注册成功"),

    UPDATE_ERROR("修改失败"),

    UPDATE_SUCCESS("修改成功"),

    ADD_ERROR("添加失败"),

    ADD_SUCCESS("添加成功"),

    DELETE_ERROR("删除失败"),

    DELETE_SUCCESS("删除成功"),

    DATA_NOT_EXIST("未查询到记录！"),

    PARAM_ERROR("参数错误！"),

    SAME_CATEGORY_EXIST("已存在同名的分类！"),

    CATEGORY_NOT_EXIST("分类不存在"),

    CATEGORY_NOT_NULL("该分类下的书籍不为空"),

    SAME_USERNAME_EXIST("用户名已存在！"),

    INDEX_BOOK_EXIST("首页已有该书籍"),

    INDEX_BOOK_NOT_EXIST("首页书籍不存在"),

    INDEX_BOOK_ADD_SUCCESS("首页书籍添加成功"),

    INDEX_BOOK_ADD_ERROR("首页书籍添加失败"),

    INDEX_BOOK_DELETE_SUCCESS("首页书籍删除成功"),

    INDEX_BOOK_DELETE_ERROR("首页书籍删除失败"),

    INDEX_BOOK_UPDATE_SUCCESS("首页书籍更新成功"),

    INDEX_BOOK_UPDATE_ERROR("首页书籍更新失败"),

    SAME_BOOK_EXIST("已存在相同书籍！"),

    BOOK_NOT_EXIST("商品不存在！"),

    BOOK_PUT_DOWN("商品已下架！"),

    PURCHASE_SUCCESS("购买成功"),

    PURCHASE_ERROR("购买失败"),

    ORDER_SUCCESS("订单结算成功"),

    ORDER_ERROR("订单结算失败");


    private String result;

    ResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

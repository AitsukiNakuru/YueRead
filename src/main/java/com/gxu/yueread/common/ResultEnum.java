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

    SAME_USERNAME_EXIST("用户名已存在！"),

    LOGIN_NAME_NULL("请输入登录名！"),

    LOGIN_NAME_IS_NOT_PHONE("请输入正确的手机号！"),

    LOGIN_PASSWORD_NULL("请输入密码！"),

    LOGIN_VERIFY_CODE_NULL("请输入验证码！"),

    LOGIN_VERIFY_CODE_ERROR("验证码错误！"),

    SAME_INDEX_CONFIG_EXIST("已存在相同的首页配置项！"),

    BOOK_CATEGORY_ERROR("分类数据异常！"),

    SAME_BOOK_EXIST("已存在相同书籍！"),

    BOOK_NOT_EXIST("商品不存在！"),

    BOOK_PUT_DOWN("商品已下架！"),

    SHOPPING_CART_ITEM_LIMIT_NUMBER_ERROR("超出单个商品的最大购买数量！"),

    SHOPPING_CART_ITEM_NUMBER_ERROR("商品数量不能小于 1 ！"),

    SHOPPING_CART_ITEM_TOTAL_NUMBER_ERROR("超出购物车最大容量！"),

    SHOPPING_CART_ITEM_EXIST_ERROR("已存在！无需重复添加！"),

    NOT_LOGIN_ERROR("未登录！"),

    ADMIN_NOT_LOGIN_ERROR("管理员未登录！"),

    TOKEN_EXPIRE_ERROR("无效认证！请重新登录！"),

    ADMIN_TOKEN_EXPIRE_ERROR("管理员登录过期！请重新登录！"),

    USER_NULL_ERROR("无效用户！请重新登录！"),

    LOGIN_USER_LOCKED_ERROR("用户已被禁止登录！"),

    ORDER_NOT_EXIST_ERROR("订单不存在！"),

    ORDER_ITEM_NOT_EXIST_ERROR("订单项不存在！"),

    NULL_ADDRESS_ERROR("地址不能为空！"),

    ORDER_PRICE_ERROR("订单价格异常！"),

    ORDER_ITEM_NULL_ERROR("订单项异常！"),

    ORDER_GENERATE_ERROR("生成订单异常！"),

    SHOPPING_ITEM_ERROR("购物车数据异常！"),

    SHOPPING_ITEM_COUNT_ERROR("库存不足！"),

    ORDER_STATUS_ERROR("订单状态异常！"),

    OPERATE_ERROR("操作失败！"),

    REQUEST_FORBIDDEN_ERROR("禁止该操作！"),

    NO_PERMISSION_ERROR("无权限！"),

    DB_ERROR("database error");

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

package com.gxu.yueread.util;

import com.gxu.yueread.entity.OrderInfo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderGenerator {
    public static OrderInfo generateOrder(Integer userId, BigDecimal totalPrice) {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        Date date = new Date();
        return new OrderInfo(simpleDateFormat.format(date), userId, totalPrice, 1);
    }
}

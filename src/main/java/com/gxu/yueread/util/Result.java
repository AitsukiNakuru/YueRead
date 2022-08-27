package com.gxu.yueread.util;



import java.io.Serializable;


public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    //业务码，比如成功、失败、权限不足等 code，可自行定义
    //@ApiModelProperty("返回码")
    private int statusCode;
    //返回信息，后端在进行业务处理后返回给前端一个提示信息，可自行定义
    //@ApiModelProperty("返回信息")
    private String message;
    //数据结果，泛型，可以是列表、单个对象、数字、布尔值等
    //@ApiModelProperty("返回数据")
    private T data;

    public Result() {
    }

    public Result(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

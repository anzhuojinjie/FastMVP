package com.joey.loanmarket.bean;

import java.io.Serializable;

/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述： 服务器返回的数据基础类型
 */
public class BaseResponse<T> implements Serializable {
    public String code;
    public String message;
    public T data;

    public boolean success() {
        return "0".equals(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}

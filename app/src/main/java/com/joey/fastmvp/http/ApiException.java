package com.joey.fastmvp.http;

/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */

public class ApiException extends RuntimeException {

    public static final int USER_NOT_EXIST = 100;
    public static final int WRONG_PASSWORD = 101;
    private String message;
    private int code = -1;
    private String time;

    public ApiException(String message) {
        this.message = message;
    }

    public ApiException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public ApiException(String message, int code, String time) {
        this.message = message;
        this.code = code;
        this.time = time;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     *
     * @param code
     * @return
     */
    private String getApiExceptionMessage(int code) {
        switch (code) {
            case USER_NOT_EXIST:
                message = "该用户不存在";
                break;
            case WRONG_PASSWORD:
                message = "密码错误";
                break;
            case 1000:
                message = "取消dialog";
                break;
            default:
                message = "未知错误";
        }
        return message;
    }
}

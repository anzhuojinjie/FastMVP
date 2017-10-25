package com.joey.fastmvp.config;

/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */
public class ConfigUtil {
    private boolean isDebug = false;//是否调试模式,上线必须改为false

    public String baseUrl = "http://api.ffrpbank.com/";
    public String getBaseUrl() {
        return baseUrl;
    }

}

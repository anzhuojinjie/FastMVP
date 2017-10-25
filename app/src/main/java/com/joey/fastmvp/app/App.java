package com.joey.fastmvp.app;

import android.app.Application;
import android.content.Context;

import com.joey.fastmvp.config.ConfigUtil;

/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 */
public class App extends Application {

    public static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }




    public static Context getContext() {
        return mApp.getApplicationContext();
    }

    //保存一些常用的配置
    private static ConfigUtil configUtil = null;

    public static ConfigUtil getConfig() {
        if (configUtil == null) {
            configUtil = new ConfigUtil();
        }
        return configUtil;
    }

}

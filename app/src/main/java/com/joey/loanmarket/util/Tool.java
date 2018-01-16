package com.joey.loanmarket.util;
public class Tool {
    /**
     * 判断是否连续点击
     * <p>
     * 对于 startActivity 设置 singletop 无效果
     * 则这样 防止 连续点击跳重复界面
     */
    private static long lastClickTime;
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}

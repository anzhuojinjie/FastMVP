package com.joey.fastmvp.ui.test.contract;

import com.joey.fastmvp.base.BaseView;
import com.joey.fastmvp.ui.test.bean.HomeIndexResponseBean;

/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */

public interface MainContract {
    interface View extends BaseView {
        void indexSuccess(HomeIndexResponseBean result);
    }
    interface Presenter{
        /**
         * 首页数据
         */
        void loadIndex();
    }
}
